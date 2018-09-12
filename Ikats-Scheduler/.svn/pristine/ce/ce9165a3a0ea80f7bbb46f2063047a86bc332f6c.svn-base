package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.ikats.scheduler.util.SZOmsPostUtil;
import com.ikats.scheduler.util.SystemOutMessage;

/**
 * @Author : liu kuo
 * @Date : 2018/7/30 15:21.
 * @Description : Indulge in study , wasting away
 */
public class OMSClientMain
{
    public static void main(String[] args)
    {
        //获取到 appkey 对应的客户关系
        String omsXml = "<eFreightService>\n" +
                "<ServiceURL>Client</ServiceURL>\n" +
                "<ServiceAction>queryClient</ServiceAction>\n" +
                "<ServiceData>\n" +
                "<ChannelId/>\n" +
                "<AdminUserName>" + 156484 + "</AdminUserName>\n" +
                "<StockId/>\n" +
                "<ClientId/>\n" +
                "</ServiceData>\n" +
                "</eFreightService>\n";

        String clients = SZOmsPostUtil.PostXml(omsXml);
//        System.out.println(clients);
        JSONObject jsonClients = (JSONObject) JSONPath.read(clients,"$");
        if(null == jsonClients)
        {
            SystemOutMessage.body("OMS --  client 查询失败 -- 终止备案发送");
            return;
        }
        String clientSuccess = jsonClients.getString("success");
        if(null == clientSuccess || !clientSuccess.equals("true"))
        {
            SystemOutMessage.body("OMS --  client 查询失败 -- 终止备案发送");
            return;
        }
        JSONArray client = jsonClients.getJSONArray("client");
        for(int i=0;i<client.size();i++)
        {

//            System.out.println(client.toString());
            JSONObject jClient = (JSONObject) client.get(i);
            String channelid = jClient.getString("channelid");
            String stockid = jClient.getString("stockid");

            System.out.println(channelid + "------"+ stockid);

        }
    }
}
