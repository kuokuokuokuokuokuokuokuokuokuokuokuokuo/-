package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.util.GuanYiPostUtil;
import com.ikats.scheduler.util.SZGuanYiPostUtil;

import java.io.IOException;

/**
 * 中仓对接管易的测试main函数
 * @Author : liu kuo
 * @Date : 2018/5/3 16:07.
 * @Description : Indulge in study , wasting away
 */
public class ZCGuanYiPostTest
{
    public static void main(String[] args) throws IOException
    {
        /*JSONObject sendJson = new JSONObject();
        sendJson.put("appkey", GuanYiPostUtil.APPKEY);
        sendJson.put("sessionkey", GuanYiPostUtil.SESSIONKEY);
        sendJson.put("method", "gy.erp.items.get");
//        sendJson.put("method", "gy.erp.items.get");
        sendJson.put("start_date","2018-01-01 00:00:00");
        sendJson.put("end_date","2018-06-11 00:00:00");
//        sendJson.put("code","SDO77384455399");
        sendJson.put("page_no",1);
        sendJson.put("page_size", "100");
        String sendString = sendJson.toJSONString();
        String sign = SZGuanYiPostUtil.sign(sendString, GuanYiPostUtil.SECRET);
        sendJson.put("sign", sign);
        String sendParam = sendJson.toJSONString();
        //管易回执
        String result = SZGuanYiPostUtil.sendPost(GuanYiPostUtil.URL, sendParam);
        System.out.println(result);*/

        /*Calendar now = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JSONObject barJson = new JSONObject();
        barJson.put("appkey", SZGuanYiPostUtil.APPKEY);
        barJson.put("sessionkey", SZGuanYiPostUtil.SESSIONKEY);
        barJson.put("method", "gy.erp.items.get");
//        barJson.put("code","KFST0067B");
        String start = sdf.format(JobDateUtil.backToThePastMinute(now, 150).getTimeInMillis());
        System.out.println(start);
        barJson.put("start_date", start);
//                sendJson.put("start_date", sdf.format(JobDateUtil.backToThePastDay(now, 2).getTimeInMillis()));
        String end = sdf.format(new Date());
        System.out.println(end);
        barJson.put("end_date", end);
        barJson.put("page_no",1);
        barJson.put("page_size", "100");
        String barString = barJson.toJSONString();
        String barSign = SZGuanYiPostUtil.sign(barString, SZGuanYiPostUtil.SECRET);
        barJson.put("sign", barSign);
        String barParam = barJson.toJSONString();
        //管易回执
        String abrResult = SZGuanYiPostUtil.sendPost(SZGuanYiPostUtil.URL, barParam);
        System.out.println(abrResult);*/
        /*JSONObject barGy = (JSONObject) JSONPath.read(abrResult, "$");
        String barSucc = barGy.getString("success");
        String barCode = "";
        if(barSucc.equals("true"))
        {
            JSONArray barCodes = (JSONArray) barGy.get("barcode");
            if(barCodes.size() > 0)
            {
                JSONObject barObject = (JSONObject)barCodes.get(0);
                barCode = barObject.getString("barcode");
            }
        }

        System.out.println(barCode);*/


        System.out.println("皮诺可 婴儿衣服婴儿连体衣夏包屁衣纯棉哈衣爬爬服婴儿衣服0-3个月新生儿连体衣短袖P0179a".length());
    }
}
