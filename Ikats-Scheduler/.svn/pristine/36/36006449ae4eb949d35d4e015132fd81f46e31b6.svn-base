package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.ikats.scheduler.util.JSTQuery;
import com.ikats.scheduler.util.JSTUtility;
import com.ikats.scheduler.util.JuShuiTanPostUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : liu kuo
 * @Date : 2018/1/25 17:09.
 * @Description : Indulge in study , wasting away
 */
public class TestA
{
    public static void main(String[] args)throws Exception
    {
        String sPartnerId = JuShuiTanPostUtil.PARTNER_ID;
        String sPartnerKey = JuShuiTanPostUtil.PARTNER_KEY;
        String sToken = JuShuiTanPostUtil.TOKEN;
        String sHostUrl = JuShuiTanPostUtil.QM_URL;

        String sMethod = "jst.orders.out.query";
        String sTaobaoAPPKEYString = JuShuiTanPostUtil.TAO_KEY;
        String sTaobaoAPPSECRET = JuShuiTanPostUtil.TAO_SECRET;
        JSTQuery api = new JSTQuery(sTaobaoAPPKEYString, sTaobaoAPPSECRET, sPartnerId, sPartnerKey, sToken, sMethod, sHostUrl);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date day = JSTUtility.getDay(new Date(), 2);
        String nowDate = format.format(day);
        String pastDate = JSTUtility.getPastDate2(2);
        System.out.println(nowDate);
        System.out.println(pastDate);
        api.AddArg("modified_begin", "2018-01-25");
        api.AddArg("modified_end", "2018-01-26");
        api.AddArg("page_index", "2");
//        api.AddArg("status", "Delivering");
//        api.AddArg("so_ids", "112062525196024326");

        String sData = api.QueryData();
        JSONObject jsonJST = (JSONObject) JSONPath.read(sData, "$");

        System.out.println(jsonJST);
    }
}
