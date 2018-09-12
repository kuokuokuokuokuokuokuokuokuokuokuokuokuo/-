package com.ikats.scheduler.test;


import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.util.JDPostUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Zhao Jianzhen
 * @Date: Created in 16:40 2018/1/10
 * @Description:
 */
public class JDBigShotNameTest {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        String method = "jingdong.ldop.alpha.vendor.bigshot.query";
        String timestamp = sdf.format(new Date());
        JSONObject object = new JSONObject();
        object.put("waybillCode ","STO00200302");
        object.put("providerId ",0001);
        //sign	签名参数，按一定规则加密后的字符串 key,value  为传入的 get 参数，按传递顺序)(加密 key 中排除sign，method，partnerid)
        // MD5(method +partnerid + (key1+value1+key2+value2+……) +partnerkey)*/
        String url = JDPostUtil.URL + "?v=2.0" + "&method=" + method + "&app_key=" + JDPostUtil.APP_KEY + "&access_token=" + JDPostUtil.ACCESS_TOKEN;
//        String sign = MD5Utils.md5(JDPostUtil.APP_SECRET+"access_token"+ JDPostUtil.ACCESS_TOKEN+"app_key"+ JDPostUtil.APP_KEY+"method"+method+"timestamp"+timestamp+"v2.0"+ JDPostUtil.APP_SECRET).toUpperCase();
        String json ="access_token"+ JDPostUtil.ACCESS_TOKEN+"app_key"+ JDPostUtil.APP_KEY+"method"+method+"timestamp"+timestamp+"v2.0";
        String sing = JDPostUtil.sign(json, JDPostUtil.APP_SECRET);
        url = url+"&sign="+sing;
        String param ="&360buy_param_json="+object.toJSONString();
        System.out.println(url);
        String result = JDPostUtil.sendPost(url, param);
        System.out.println(result);
    }
}
