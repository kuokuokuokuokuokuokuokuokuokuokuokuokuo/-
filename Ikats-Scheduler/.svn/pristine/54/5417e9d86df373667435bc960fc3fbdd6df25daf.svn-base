package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.util.SZGuanYiPostUtil;

/**
 * @Author : liu kuo
 * @Date : 2018/6/14 14:37.
 * @Description : Indulge in study , wasting away
 */
public class LKTest
{

/*    private static String APP_KEY = "156484";
    private static String SECRET = "557c67476fc34c6bbac3d32d9340bfad";
    private static String SESSION_KEY = "6b4bb42b124a4cb780a4564e7ea7e20b";*/

    public static void main(String[] args) throws Exception
    {
        JSONObject sendJson = new JSONObject();
        sendJson.put("appkey", "156484");//SZGuanYiPostUtil.APPKEY
        sendJson.put("sessionkey", "6b4bb42b124a4cb780a4564e7ea7e20b");//SZGuanYiPostUtil.SESSIONKEY
        sendJson.put("method", "gy.erp.trade.deliverys.get");

        sendJson.put("code", "SDO85519644235");
        sendJson.put("page_no", 1);
        sendJson.put("page_size", "100");
        sendJson.put("delivery", "0");
        String sendString = sendJson.toJSONString();
        String sign = SZGuanYiPostUtil.sign(sendString,"557c67476fc34c6bbac3d32d9340bfad");//SZGuanYiPostUtil.SECRET
        sendJson.put("sign", sign);
        String sendParam = sendJson.toJSONString();
        //管易回执
        String result = SZGuanYiPostUtil.sendPost(SZGuanYiPostUtil.URL, sendParam);//SZGuanYiPostUtil.URL

        System.out.println(result);
    }
}
