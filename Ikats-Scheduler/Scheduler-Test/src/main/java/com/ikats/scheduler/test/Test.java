package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.ikats.scheduler.util.JuShuiTanPostUtil;

import java.io.IOException;

/**
 * @Author : liu kuo
 * @Date : 2018/1/3 16:31.
 * @Description : Indulge in study , wasting away
 */
public class Test
{
    public static void main(String[] args) throws IOException
    {
        String sPartnerId=JuShuiTanPostUtil.PARTNER_ID;
        String sPartnerKey=JuShuiTanPostUtil.PARTNER_KEY;
        String sToken=JuShuiTanPostUtil.TOKEN;
        String sHostUrl=JuShuiTanPostUtil.QM_URL;
//        String sMethod="jst.orders.query";
        String sMethod="jst.orders.out.query";
        String sTaobaoAPPKEYString= JuShuiTanPostUtil.TAO_KEY;
        String sTaobaoAPPSECRET=JuShuiTanPostUtil.TAO_SECRET;
        Query api=new Query(sTaobaoAPPKEYString,sTaobaoAPPSECRET,sPartnerId,sPartnerKey,sToken,sMethod,sHostUrl);
        api.AddArg("modified_begin","2018-1-25");
        api.AddArg("modified_end","2018-1-26");
//        api.AddArg("modified_begin","2018-01-01 12:12:21");
//        api.AddArg("modified_end","2018-01-06 12:12:21");
//        api.AddArg("status", "Delivering");
        api.AddArg("so_ids", "112062525196024326");
//        api.AddArg("shop_id", "14585");
        String sData=  api.QueryData();
        JSONObject jsonJST = (JSONObject) JSONPath.read(sData, "$");
        JSONObject response = jsonJST.getJSONObject("response");
//        boolean success = response.getBoolean("issuccess");
//        JSONArray orders = response.getJSONArray("orders");
        System.out.println(response);

    }
}
