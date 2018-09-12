package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.ikats.scheduler.util.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 四洲对接管易的测试main函数
 * @Author : liu kuo
 * @Date : 2018/5/3 16:07.
 * @Description : Indulge in study , wasting away
 */
public class SZGuanYiPostTest
{
    public static void main(String[] args) throws IOException
    {
        JSONObject sendJson = new JSONObject();
        sendJson.put("appkey","108566");
        sendJson.put("sessionkey","aac97d7fd496467695acca50535d96e0");
        sendJson.put("method", "gy.erp.trade.deliverys.get");
//        sendJson.put("method", "gy.erp.items.get");
//        sendJson.put("start_date","2018-07-28 00:00:00");
        sendJson.put("code","SDO85116886781");
//        sendJson.put("end_date","2018-07-30 14:20:00");
        sendJson.put("page_no",1);
        sendJson.put("page_size", "100");
        String sendString = sendJson.toJSONString();
        String sign = SZGuanYiPostUtil.sign(sendString,"2dcd34f446c242bfb7696dc3ab7d0fa5");
        sendJson.put("sign", sign);
        String sendParam = sendJson.toJSONString();
        System.out.println(sendParam);
        //管易回执
        String result = SZGuanYiPostUtil.sendPost(SZGuanYiPostUtil.URL, sendParam);
        System.out.println(result);
    }
}
