package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.util.JDPostUtil;
import com.ikats.scheduler.util.JSTUtility;
import sun.rmi.runtime.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Zhao Jianzhen
 * @Date: Created in 17:14 2018/1/9
 * @Description: 获取京东token
 */
public class JDGetTokenTest {
    public static void main(String[] args){
        StringBuilder url = new StringBuilder();
        url.append("https://oauth.jd.com/oauth/token?grant_type=authorization_code&client_id="+JDPostUtil.APP_KEY
                +"&client_secret="+ JDPostUtil.APP_SECRET
                +"&scope=read&redirect_uri="+ JDPostUtil.CALLBACK_URL
                +"&code="+ "0nfT2s"
                +"&state=1234");
        System.out.println(url);
        try {
            String  result= JDPostUtil.sendPost(url.toString(), "");
            System.out.println(result);
            JSONObject jsStr = JSONObject.parseObject(result);

            String access_token = jsStr.getString("access_token");
            System.out.println(access_token);
        }catch (Exception ex){
            System.out.println(ex);
        }

        /*时间测试
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        System.out.println(date);
        System.out.println("========================");
        String pastDate = getPastDate(7);
        Date day = getDay(new Date(), 7);
        String format1 = format.format(day);
        System.out.println(pastDate);
        System.out.println("========================");
        System.out.println(format1);
        String nowDate = format.format(new Date());
        String pastDate = JSTUtility.getPastDate(1);
        Date day = JSTUtility.getDay(new Date(), 1);
        String nowDate = format.format(day);
        String pastDate = JSTUtility.getPastDate2(1);
        System.out.println( "nowDate =="+nowDate);
        System.out.println("pastDate =="+pastDate);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = format.format(new Date());
        String pastDate = JSTUtility.getPastDate2(7);
        Date day = JSTUtility.getDay(new Date(), 1);
        String format1 = format.format(day);
        System.out.println(nowDate);
        System.out.println("=======================");
        System.out.println(pastDate);
        System.out.println("=======================");
        System.out.println(format1);*/
    }
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static Date getDay(Date date,int addDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, addDay);
        date = calendar.getTime();
        return date;
    }
}
