package com.ikats.scheduler.test;

import com.ikats.scheduler.util.JuShuiTanPostUtil;
import com.ikats.scheduler.util.MD5Utils;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author : liu kuo
 * @Date : 2018/1/2 14:59.
 * @Description : Indulge in study , wasting away
 */
public class JuShuiTanOrderTest {
    public static void main(String[] args) throws IOException
    {
        String method = "jst.orders.query";
        String url = "http://a1q40taq0j.api.taobao.com/router/qmtest";
        Long ts = System.currentTimeMillis()/1000;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        url = url + "?partnerid=" + JuShuiTanPostUtil.PARTNER_ID + "&token=" + JuShuiTanPostUtil.TOKEN  + "&method="+ method + "&ts=" + ts
                + "&app_key=" + JuShuiTanPostUtil.TAO_KEY + "&format=json&sign_method=md5&timestamp=" + URLEncoder.encode(sdf.format(date),"utf-8") + "&v=2.0&target_app_key=23060081";

 //        jstsign  增加聚水潭签名，   MD5(method.replace("jst.","") +partnerid + token+tokenvalue+ts+tsvalue +partnerkey)

        String jstsign = MD5Utils.md5(method.replace("jst.","") + JuShuiTanPostUtil.PARTNER_ID + "token" + JuShuiTanPostUtil.TOKEN + "ts" + ts + JuShuiTanPostUtil.PARTNER_KEY);

        Map<String,String> dicArg = new HashMap();
        dicArg.put("token",JuShuiTanPostUtil.TOKEN);
        if(dicArg.get("ts")==null)
        {
            dicArg.put("ts", String.valueOf(System.currentTimeMillis()/1000));
        }
        String sSign = method.replace("jst.", "") + JuShuiTanPostUtil.PARTNER_ID + GetJstSignPara(dicArg) + JuShuiTanPostUtil.PARTNER_KEY;

        dicArg.put("jstsign",Utility.DoMD5(sSign,null));
        dicArg.put("app_key",JuShuiTanPostUtil.PARTNER_KEY);
        dicArg.put("format","json");
        dicArg.put("method", method);
        dicArg.put("sign_method","md5");
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        dicArg.put("timestamp", formatter.format(date));
        dicArg.put("target_app_key", "23060081");
        dicArg.put("partnerid",JuShuiTanPostUtil.PARTNER_ID);
        dicArg.put("sign", GetSign(dicArg));

        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(url);
        Boolean isFirst = true;
        Iterator<Map.Entry<String, String>> iterator = dicArg.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if(isFirst)
            {
                sbUrl.append("?");
            }
            else
            {
                sbUrl.append("&");
            }
            sbUrl.append(entry.getKey());
            sbUrl.append("=");
            sbUrl.append(URLEncoder.encode(entry.getValue(),"UTF-8"));
            isFirst = false;
        }
        System.out.println(sbUrl.toString());
        url = sbUrl.toString();
        String result = JuShuiTanPostUtil.sendPost(url,"");
        System.out.println(result);
    }

    private static String GetSign(Map<String, String> dicArg)
    {
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(dicArg.entrySet());
        Collections.sort(list,new Comparator<Entry<String,String>>() {
            //升序排序
            @Override
            public int compare(Entry<String, String> o1,
                               Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });


        StringBuilder prestr = new StringBuilder();
        prestr.append(JuShuiTanPostUtil.TAO_SECRET);
        for(Map.Entry<String,String> mapping:list)
        {
            prestr.append(mapping.getKey());
            prestr.append(mapping.getValue());
        }
        prestr.append(JuShuiTanPostUtil.TAO_SECRET);
        System.out.println(prestr.toString());
        System.out.println(Utility.DoMD5(prestr.toString(),null).toUpperCase());
        return Utility.DoMD5(prestr.toString(),null).toUpperCase();
    }

    protected static String GetJstSignPara(Map<String, String> dicArg) {
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(dicArg.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            //升序排序
            public int compare(Entry<String, String> o1,
                               Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });
        StringBuilder prestr = new StringBuilder();

        for(Map.Entry<String,String> mapping:list){
            if (mapping.getKey() == "sign" || mapping.getKey()== "method" || mapping.getKey() == "partnerid" ||mapping.getKey() == "jstsign" ||
                    mapping.getKey() == "timestamp" || mapping.getKey() == "app_key")
                continue;
            prestr.append(mapping.getKey() + mapping.getValue());
        }
        return prestr.toString();
    }
}
