package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.util.GuanYiPostUtil;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : liu kuo
 * @Date : 2018/4/19 14:47.
 * @Description : Indulge in study , wasting away
 */
public class MarsT1
{
    public static void main(String[] args) throws IOException
    {
        JSONObject object = new JSONObject();
        JSONObject login = new JSONObject();
        login.put("userName","admin");
        login.put("passWord","123456q");
        login.put("loginType","alias");
        object.put("login",login);

        String result = GuanYiPostUtil.sendPost("http://uat.wms.chigoose.com/UserFact/login.action",object.toJSONString());

        System.out.println(result);
    }
}
