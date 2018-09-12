package com.ikats.scheduler.test;


import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.util.JDPostUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Zhao Jianzhen
 * @Date: Created in 16:40 2018/1/9
 * @Description:
 */
public class JDGetWayBillCodeCodeTest {

    public static void main(String[] args) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        String method = "jingdong.ldop.alpha.waybill.receive";
        String timestamp = sdf.format(new Date());
        JSONObject object = new JSONObject();
        JSONObject content = new JSONObject();
        JSONObject fromAddress = new JSONObject();
        JSONObject toAddress = new JSONObject();
        content.put("waybillType",1);
        content.put("waybillCount",1);
        content.put("providerId",1327);
        content.put("providerCode","YUNDA");
        content.put("branchCode","A0001");
        content.put("platformOrderNo","");
        content.put("salePlatform","0010001");
        content.put("platformOrderNo","20000000100");
        content.put("vendorCode","10001");
        content.put("vendorName","阿迪达斯旗舰店");
        content.put("venderOrderCode","112323424");
        fromAddress.put("provinceId",10);
        fromAddress.put("provinceName","北京");
        fromAddress.put("cityId",101);
        fromAddress.put("cityName","北京市");
        fromAddress.put("countryId",10120);
        fromAddress.put("countryName","朝阳区");
        fromAddress.put("countrysideId",10120002);
        fromAddress.put("countrysideName","和平里北街");
        fromAddress.put("address","京市朝阳区沙井镇上星路1001号");
        fromAddress.put("contact","李四");
        fromAddress.put("phone","18810909090");
        fromAddress.put("mobile","010-99929991");
        content.put("fromAddress",fromAddress);
        toAddress.put("provinceId",10);
        toAddress.put("provinceName","北京");
        toAddress.put("cityId",101);
        toAddress.put("cityName","北京市");
        toAddress.put("countryId",10120);
        toAddress.put("countryName","朝阳区");
        toAddress.put("countrysideId",10120002);
        toAddress.put("countrysideName","和平里南街");
        toAddress.put("address","北京市朝阳区宝安区沙井镇上星路1002号");
        toAddress.put("contact","李四");
        toAddress.put("phone","12588888889");
        toAddress.put("mobile","010-20202020");
        content.put("toAddress",toAddress);
        content.put("weight",10.23);
        content.put("volume",9000.00);
        content.put("payType",0);
        content.put("shouldPayMoney",900.00);
        content.put("needGuarantee",false);
        content.put("guaranteeMoney",0.0);
        object.put("content",content);
        //sign	签名参数，按一定规则加密后的字符串 key,value  为传入的 get 参数，按传递顺序)(加密 key 中排除sign，method，partnerid)
        // MD5(method +partnerid + (key1+value1+key2+value2+……) +partnerkey)*/
        String url = JDPostUtil.URL + "?v=2.0" + "&method=" + method + "&app_key=" + JDPostUtil.APP_KEY + "&access_token=" + JDPostUtil.ACCESS_TOKEN;
//        String sign = MD5Utils.md5(JDPostUtil.APP_SECRET+"access_token"+ JDPostUtil.ACCESS_TOKEN+"app_key"+ JDPostUtil.APP_KEY+"method"+method+"timestamp"+timestamp+"v2.0"+ JDPostUtil.APP_SECRET).toUpperCase();
        String json ="access_token"+ JDPostUtil.ACCESS_TOKEN+"app_key"+ JDPostUtil.APP_KEY+"method"+method+"timestamp"+timestamp+"v2.0";
        String sing = JDPostUtil.sign(json, JDPostUtil.APP_SECRET);
        url = url+"&sign="+sing;
        System.out.println(url);
        String param ="&360buy_param_json="+object.toJSONString();
        String result = JDPostUtil.sendGet(url,param);
        System.out.println("result = "+result);
        JSONObject jsStr = JSONObject.parseObject(result);
        String statusMessage = jsStr.getString("statusMessage");
        System.out.println("=======================");
        System.out.println("statusMessage = "+statusMessage);
    }
}
