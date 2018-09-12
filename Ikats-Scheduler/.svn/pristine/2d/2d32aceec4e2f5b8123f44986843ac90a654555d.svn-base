package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.util.JuShuiTanPostUtil;
import com.ikats.scheduler.util.MD5Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : liu kuo
 * @Date : 2018/1/2 14:59.
 * @Description : Indulge in study , wasting away
 */
public class JuShuiTanTest {
    public static void main(String[] args) throws IOException
    {
        String method = "purchase.query";
        Long ts = System.currentTimeMillis()/1000;
        List<String> a = new ArrayList<String>();
        a.add("745");
        JSONObject object = new JSONObject();
        object.put("modified_begin","2018-1-01 15:35:47");
        object.put("modified_end","2018-01-06 15:36:06");
        object.put("page_index",1);
        object.put("page_size",30);
        object.put("so_ids",a);
        //sign	签名参数，按一定规则加密后的字符串 key,value  为传入的 get 参数，按传递顺序)(加密 key 中排除sign，method，partnerid)
        // MD5(method +partnerid + (key1+value1+key2+value2+……) +partnerkey)*/
        String url = JuShuiTanPostUtil.URL + "?token=" + JuShuiTanPostUtil.TOKEN + "&ts=" + ts + "&partnerid=" + JuShuiTanPostUtil.PARTNER_ID + "&method=" + method;
        String objectValue = "token" + JuShuiTanPostUtil.TOKEN + "ts" + ts;
        String sign = MD5Utils.md5(method + JuShuiTanPostUtil.PARTNER_ID + objectValue + JuShuiTanPostUtil.PARTNER_KEY);
        url = url + "&sign=" + sign;
//        System.out.println(url);
        String msg = object.toJSONString();
//        System.out.println(msg);
        String result = JuShuiTanPostUtil.sendPost(url,msg);
        System.out.println(result);
    }
}
