package com.ikats.scheduler.job;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.email.Email;
import com.ikats.scheduler.entity.bean.JSTSkuBean;
import com.ikats.scheduler.entity.enumerate.GYStatus;
import com.ikats.scheduler.logic.JSTSkuLogic;
import com.ikats.scheduler.util.JSTUtility;
import com.ikats.scheduler.util.JuShuiTanPostUtil;
import com.ikats.scheduler.util.MD5Utils;
import com.ikats.scheduler.util.SystemOutMessage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 定时任务获取聚水潭商品备案
 *
 * @Author : liu kuo
 * @Date : 2017/10/26 15:14.
 * @Description : Indulge in study , wasting away
 */

public class JuShuiTanSkuRegisterJob extends QuartzJobBean {

    @Autowired
    private JSTSkuLogic skuLogic;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SystemOutMessage.start("JuShuiTan_GetSkuRegister",sdf.format(new Date()));
        if(null == skuLogic)
        {
            SystemOutMessage.body("false 系统异常");
            return;
        }
        List<JSTSkuBean> skuBeans = new ArrayList<JSTSkuBean>();
        try {
            for (int page =1;page<10000;page++){

                String method = "sku.query";
                Long ts = System.currentTimeMillis()/1000;

                JSONObject object = new JSONObject();
                String nowDate = sdf.format(new Date());
                String pastDate = JSTUtility.getPastDate(1);
                object.put("modified_begin",pastDate);
                object.put("modified_end",nowDate);
                object.put("page_index",page);
                object.put("page_size",30);
                //sign	签名参数，按一定规则加密后的字符串 key,value  为传入的 get 参数，按传递顺序)(加密 key 中排除sign，method，partnerid)
                // MD5(method +partnerid + (key1+value1+key2+value2+……) +partnerkey)*/
                String url = JuShuiTanPostUtil.URL + "?token=" + JuShuiTanPostUtil.TOKEN + "&ts=" + ts + "&partnerid=" + JuShuiTanPostUtil.PARTNER_ID + "&method=" + method;
                String objectValue = "token" + JuShuiTanPostUtil.TOKEN + "ts" + ts;
                String sign = MD5Utils.md5(method + JuShuiTanPostUtil.PARTNER_ID + objectValue + JuShuiTanPostUtil.PARTNER_KEY);
                url = url + "&sign=" + sign;
                String msg = object.toJSONString();

                String result = JuShuiTanPostUtil.sendPost(url,msg);
                JSONObject jsStr = JSONObject.parseObject(result);
                JSONArray datas = jsStr.getJSONArray("datas");

                for (int i =0;i<datas.size();i++){
                    JSONObject skuRegister = (JSONObject)datas.get(i);
                    String skuCode = skuRegister.getString("sku_id");
                    String omsXml = "<Service>\n" +
                            "  <ServiceURL>SKURegister</ServiceURL>\n" +
                            "  <ServiceAction>TRANSACTION</ServiceAction>\n" +
                            "  <UserName></UserName>" +
                            "  <ServiceData>\n" +
                            "    <SKURegister>\n" +
                            "      <ClientId></ClientId>\n" +
                            "      <SKUCode>"+(skuRegister.getString("sku_id") ==null ? "":skuRegister.getString("sku_id"))+"</SKUCode>\n" +
                            "      <GoodsItemNo></GoodsItemNo>\n" +
                            "      <SKUName>"+(skuRegister.getString("name") ==null ? skuRegister.getString("short_name"):skuRegister.getString("name"))+"</SKUName>\n" +
                            "      <SKUPrice>"+(skuRegister.getBigDecimal("sale_price") == null ? "":skuRegister.getBigDecimal("sale_price"))+"</SKUPrice>\n" +
                            "      <SKUCount></SKUCount>\n" +
                            "      <SKUModel>"+(skuRegister.getString("properties_value") ==null ? "":skuRegister.getString("properties_value"))+"</SKUModel>\n" +
                            "      <MailTaxNo></MailTaxNo>\n" +
                            "      <HsCode></HsCode>\n" +
                            "      <WarehouseNo></WarehouseNo>\n" +
                            "      <WarehouseLocation></WarehouseLocation>\n" +
                            "      <DeclareMeasureUnit></DeclareMeasureUnit>\n" +
                            "      <ProductionMarketingCountry></ProductionMarketingCountry>\n" +
                            "      <GoodsNetWeight>"+(skuRegister.getBigDecimal("weight") ==null ? "":skuRegister.getBigDecimal("weight"))+"</GoodsNetWeight>\n" +
                            "      <GoodsRoughWeight>"+(skuRegister.getBigDecimal("weight") == null ? "":skuRegister.getBigDecimal("weight"))+"</GoodsRoughWeight>\n" +
                            "      <Length></Length> \t  <Width></Width> \t  <Height></Height>\n" +
                            "      <Description></Description>\n" +
                            "      <LabelCode>"+(skuRegister.get("sku_code") ==null ? skuRegister.getString("sku_id"):skuRegister.get("sku_code"))+"</LabelCode>\n" +
                            "      <LabelCode1></LabelCode1>\n" +
                            "      <LabelCode2></LabelCode2>\n" +
                            "      <LabelCode3></LabelCode3>\n" +
                            "      <SKUImageURL1>"+(skuRegister.get("pic") == null ? "":skuRegister.get("pic")) +"</SKUImageURL1>\n" +
                            "      <SKUImageURL2></SKUImageURL2>\n" +
                            "      <SKUImageURL3></SKUImageURL3>\n" +
                            "      <SKUImageURL4></SKUImageURL4>\n" +
                            "      <SKUImageURL5></SKUImageURL5>\n" +
                            "      <FirstUnit></FirstUnit>\n" +
                            "      <SecondUnit></SecondUnit>\n" +
                            "     <Brand>"+(skuRegister.get("brand") == null ? "":skuRegister.get("brand"))+"</Brand>\n" +
                            "     <DueDays></DueDays>\n" +
                            "    <WarningStock></WarningStock>\n" +
                            "    </SKURegister>\n" +
                            "  </ServiceData>\n" +
                            "</Service>\n";

                    JSTSkuBean skuBean = new JSTSkuBean();
                    skuBean.setAppKey(JuShuiTanPostUtil.PARTNER_ID);
                    skuBean.setState(GYStatus.INIT.getValue());
                    skuBean.setTimes(0);
                    skuBean.setSkuCode(skuCode);
                    skuBean.setCreateTime(new Date());
                    skuBean.setOmsRequest(omsXml);
                    skuBeans.add(skuBean);

                }
                if (datas.size() < 30) break;
            }

            this.skuLogic.insertList(skuBeans);
            if(!skuLogic.getSuccess())
            {
                SystemOutMessage.body( this.skuLogic.getSuccess()+ this.skuLogic.getMessage());
                return;
            }

        }catch (Exception e){
            SystemOutMessage.body(" false  " + e.getMessage());
            Email.sendTextMail("liukuo@ikats.com", "聚水潭商品备案抓取任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("zhangxiaotao@ikats.com", "聚水潭商品备案抓取任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("wuqing@ikats.com", "聚水潭商品备案抓取任务", ExceptionUtils.getStackTrace(e));
        }
        SystemOutMessage.end("JuShuiTan_GetSkuRegister",sdf.format(new Date()));
    }
}
