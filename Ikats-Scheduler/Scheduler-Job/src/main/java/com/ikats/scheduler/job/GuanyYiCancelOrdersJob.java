package com.ikats.scheduler.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.ikats.scheduler.email.Email;
import com.ikats.scheduler.entity.bean.CancelOrderBean;
import com.ikats.scheduler.entity.enumerate.SendStatus;
import com.ikats.scheduler.logic.CancelOrderLogic;
import com.ikats.scheduler.util.GuanYiPostUtil;
import com.ikats.scheduler.util.JobDateUtil;
import com.ikats.scheduler.util.OmsPostUtil;
import com.ikats.scheduler.util.SystemOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 定时任务获取管易的发货单 - 已取消的订单
 *
 * @Author : liu kuo
 * @Date : 2017/10/26 15:14.
 * @Description : Indulge in study , wasting away
 */

public class GuanyYiCancelOrdersJob extends QuartzJobBean {

    @Autowired
    private CancelOrderLogic orderLogic;


    private static String FACE_NAME = "gy.erp.trade.deliverys.get";

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SystemOutMessage.start("GuanYi_GetCancelOrders", sdf.format(new Date()));
        if (null == orderLogic)
        {
            SystemOutMessage.body("false 系统异常");
            return;
        }
        //解析回执数据
        List<CancelOrderBean> cancelBeans = new ArrayList<CancelOrderBean>();
        try {
            //获取到 appkey 对应的客户关系
            String clientXml = "<eFreightService>\n" +
                    "<ServiceURL>Client</ServiceURL>\n" +
                    "<ServiceAction>queryClient</ServiceAction>\n" +
                    "<ServiceData>\n" +
                    "<ChannelId/>\n" +
                    "<AdminUserName>" + GuanYiPostUtil.APPKEY + "</AdminUserName>\n" +
                    "<StockId/>\n" +
                    "<ClientId/>\n" +
                    "</ServiceData>\n" +
                    "</eFreightService>\n";

            String clients = OmsPostUtil.PostXml(clientXml);
            JSONObject jsonClients = (JSONObject) JSONPath.read(clients, "$");
            if (null == jsonClients)
            {
                SystemOutMessage.body("OMS --  client 查询失败 -- 终止取消订单查询");
                return;
            }
            String clientSuccess = jsonClients.getString("success");
            if (null == clientSuccess || !clientSuccess.equals("true"))
            {
                SystemOutMessage.body("OMS --  client 查询失败 -- 终止取消订单查询");
                return;
            }
            JSONArray client = jsonClients.getJSONArray("client");
            for (int i = 0; i < client.size(); i++)
            {
                for (int page = 1; page < 10000; page++)
                {
                    JSONObject jClient = (JSONObject) client.get(i);
                    //客户
                    String clientId = jClient.getString("clientid");
                    //仓库
                    String stockId = jClient.getString("stockid");
                    //渠道
                    String channelId = jClient.getString("channelid");
                    Calendar now = Calendar.getInstance();
                    JSONObject sendJson = new JSONObject();
                    sendJson.put("appkey", GuanYiPostUtil.APPKEY);
                    sendJson.put("sessionkey", GuanYiPostUtil.SESSIONKEY);
                    sendJson.put("method", FACE_NAME);
                    sendJson.put("warehouse_code", stockId);
                    sendJson.put("shop_code", channelId);
                    sendJson.put("end_modify_date", sdf.format(new Date()));
                    sendJson.put("start_modify_date", sdf.format(JobDateUtil.backToThePastMinute(now, 10).getTimeInMillis()));
                    // 0:不返回已作废的单据 ; 1:返回已作废的单据
                    sendJson.put("del", 1);
                    sendJson.put("page_no", page);
                    sendJson.put("page_size", 100);
                    String sendString = sendJson.toJSONString();
                    String sign = GuanYiPostUtil.sign(sendString, GuanYiPostUtil.SECRET);
                    sendJson.put("sign", sign);
                    String sendParam = sendJson.toJSONString();
                    //管易回执
                    String result = GuanYiPostUtil.sendPost(GuanYiPostUtil.URL, sendParam);
                    JSONObject jsonGy = (JSONObject) JSONPath.read(result, "$");
                    String success = jsonGy.getString("success");

                    if (success.equals("false")){
                        break;
                    }

                    JSONArray deliverys = (JSONArray) jsonGy.get("deliverys");
                    if (null == deliverys || deliverys.size() == 0)
                    {
                        break;
                    }
                    for (int j = 0; j < deliverys.size(); j++)
                    {
                        //某个订单
                        JSONObject order = (JSONObject) deliverys.get(j);
                        String cancel = order.getString("cancel");
                        if(StringUtils.isNotBlank(cancel) && cancel.equals("0"))
                        {
                            continue;
                        }
                        CancelOrderBean orderBean = new CancelOrderBean();
                        orderBean.setAppKey(GuanYiPostUtil.APPKEY);
                        orderBean.setIdRecord(1L);
                        orderBean.setOrderNo(order.getString("code"));
                        orderBean.setState(SendStatus.INIT.getValue());
                        orderBean.setTimes(0);
                        orderBean.setCreateTime(new Date());
                        String omsXml =
                                "<Service>\n" +
                                        "<ServiceURL>OMSOrder</ServiceURL>\n" +
                                        "<ServiceAction>CancelOrder</ServiceAction>\n" +
                                        "<ServiceData>\n" +
                                        "<OrderNo>" + order.getString("code") + "</OrderNo>\n" +
                                        "<UserName>" + clientId + "</UserName>\n" +
                                        "<Operater>" + clientId + "</Operater>\n" +
                                        "</ServiceData>\n" +
                                        "</Service>\n";

                        orderBean.setOmsRequest(omsXml);
                        cancelBeans.add(orderBean);
                    }
                    if (deliverys.size() < 100) break;
                }
            }

            this.orderLogic.insertList(cancelBeans);
            if (!orderLogic.getSuccess())
            {
                SystemOutMessage.body(this.orderLogic.getSuccess() + this.orderLogic.getMessage());
                return;
            }
        }catch (Exception e)
        {
            SystemOutMessage.body(" false  " + e.getMessage());
            Email.sendTextMail("liukuo@ikats.com", "管易取消订单抓取任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("zhangxiaotao@ikats.com", "管易取消订单抓取任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("wuqing@ikats.com", "管易取消订单抓取任务", ExceptionUtils.getStackTrace(e));
        }
        SystemOutMessage.end("GuanYi_GetCancelOrders", sdf.format(new Date()));
    }
}
