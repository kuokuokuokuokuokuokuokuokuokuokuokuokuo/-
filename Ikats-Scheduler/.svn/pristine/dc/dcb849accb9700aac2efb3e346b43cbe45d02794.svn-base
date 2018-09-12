package com.ikats.scheduler.job.sizhou;

import com.ikats.scheduler.email.Email;
import com.ikats.scheduler.entity.bean.GYOrderBean;
import com.ikats.scheduler.entity.bean.SZEmailBean;
import com.ikats.scheduler.entity.enumerate.SendStatus;
import com.ikats.scheduler.entity.exception.DmsOrderSettlementException;
import com.ikats.scheduler.logic.GYOrderLogic;
import com.ikats.scheduler.logic.SZEmailLogic;
import com.ikats.scheduler.util.SZOmsPostUtil;
import com.ikats.scheduler.util.SystemOutMessage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author : liu kuo
 * @Date : 2017/10/26 15:14.
 * @Description : Indulge in study , wasting away
 */

public class SZSendOmsOrderJob extends QuartzJobBean
{

    @Autowired
    private GYOrderLogic logic;

    @Autowired
    private SZEmailLogic emailLogic;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SystemOutMessage.start("OMS_SendOrderRegister",sdf.format(new Date()));
        if(null == logic)
        {
            SystemOutMessage.body("false 系统异常");
            return;
        }
        List<GYOrderBean> updateBeans = new ArrayList<GYOrderBean>();
        try
        {
            List<GYOrderBean> orderBeans = this.logic.getOrderSendJob();
            if(null == orderBeans || orderBeans.size() ==0)
            {
                SystemOutMessage.body("没有新的订单可发送");
                return;
            }
            for(GYOrderBean bean : orderBeans)
            {
                GYOrderBean update = new GYOrderBean();
                update.setId(bean.getId());
                update.setTimes(bean.getTimes() + 1);
                update.setSendTime(new Date());
                String result = SZOmsPostUtil.PostXml(bean.getOmsRequest());
                if(result.contains("<ResultCode>1</ResultCode>") || result.contains("<ResultCode>2</ResultCode>"))
                {
                    update.setState(SendStatus.SEND_OK.getValue());
                }
                else
                {
                    if(result.contains("面单不足"))//面单不足发邮件给四洲的人
                    {
                        SystemOutMessage.body("面单不足");

                        SimpleDateFormat todaySdf = new SimpleDateFormat("yyyyMMdd");
                        Map<String,String> express = new HashMap<String, String>();
                        String today = todaySdf.format(new Date());
                        express.put("today",today);
                        Long count = this.emailLogic.selectCount(express);
                        if(null == count || count < 1)
                        {
                            String content =
                                    "尊敬的客户：\n" +
                                            "        您好！\n" +
                                            "        感谢使用知行思远信息技术有限公司WMS仓储管理系统。\n" +
                                            "        系统监控到韵达面单不足，请联系合作的韵达网点解决此问题。\n" +
                                            "\n" +
                                            "        此邮件无需回复，如有其他疑问可及时与知行技术工程师联系，谢谢！\n" +
                                            "\n" +
                                            "知行思远信息技术有限公司（技术支持）";
                            Email.sendTextMail("zhangpengfei@ikats.com", "面单不足",content);
                            Email.sendTextMail("wuqing@ikats.com", "面单不足",content);
                            Email.sendTextMail("liukuo@ikats.com", "面单不足",content);

                            Email.sendTextMail("vincent.y@fsmlonline.com", "面单不足",content);
                            Email.sendTextMail("allen.c@fsmlonline.com", "面单不足",content);
                            Email.sendTextMail("xiaoming.c@fsmlonline.com", "面单不足",content);
                            Email.sendTextMail("city.c@fsmlonline.com", "面单不足",content);
                            Email.sendTextMail("lian.w@fsmlonline.com", "面单不足",content);
                            Email.sendTextMail("sampe.c@fsmlonline.com", "面单不足",content);
                            Email.sendTextMail("jing.f@fsmlonline.com", "面单不足",content);

                            SZEmailBean email = new SZEmailBean();
                            email.setToday(today);
                            email.setCreateTime(new Date());
                            this.emailLogic.insert(email);
                        }
                        update.setState(SendStatus.SEND_MDBZ.getValue());
                    }
                    else
                    {
                        update.setState(SendStatus.SEND_ERROR.getValue());
                    }
                }
                update.setReturnTime(new Date());
                update.setOmsResponse(result);

                updateBeans.add(update);
            }
        }catch (DmsOrderSettlementException e)
        {
            SystemOutMessage.body(" false  " + e.getMessage());
            Email.sendTextMail("liukuo@ikats.com", "四洲订单发送任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("zhangxiaotao@ikats.com", "四洲订单发送任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("wuqing@ikats.com", "四洲订单发送任务", ExceptionUtils.getStackTrace(e));
        }finally
        {
            for(GYOrderBean bean : updateBeans)
            {
                this.logic.update(bean);
            }
            SystemOutMessage.end("OMS_SendOrderRegister",sdf.format(new Date()));
        }
    }
}
