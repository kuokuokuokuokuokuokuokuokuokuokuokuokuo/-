package com.ikats.scheduler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

/**
 * 管易配置和发送的 工具 -- 用户四洲
 * @Author : liu kuo
 * @Date : 2018/5/3
 * @Description : Indulge in study , wasting away
 */
public class SZGuanYiPostUtil
{
    //测试环境 管易配置
    public static final String URL = "http://v2.api.guanyiyun.com/rest/erp_open";
    //测试
    //public static final String APPKEY = "180610";
    //public static final String SECRET = "e248f0b185b7435f802433ad54b0eb63";
    //public static final String SESSIONKEY = "532819f4cad84f2b8ae44abcf32c1999";
    //正式的
    public static final String APPKEY = "108566";
    public static final String SECRET = "2dcd34f446c242bfb7696dc3ab7d0fa5";
//    public static final String SESSIONKEY = "0295987bacc943d587a50609b18f8228";
//    public static final String SESSIONKEY = "c5a64555e60b462c813f91ee01680dca";
    public static final String SESSIONKEY = "aac97d7fd496467695acca50535d96e0";

    public static String sign(String json,String secret){
        StringBuilder enValue = new StringBuilder();
        //前后加上secret
        enValue.append(secret);
        enValue.append(json);
        enValue.append(secret);
        // 使用MD5加密(32位大写)
        byte[] bytes = encryptMD5(enValue.toString());
        return byte2hex(bytes);
    }

    private static byte[] encryptMD5(String data) {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    /**
     * 向指定URL发送POST方法的请求
     *
     * @param url    发送请求的URL
     * @param params 请求参数，请求参数应该是name1=value1&name2=value2的形式。
     * @return URL所代表远程资源的响应
     */
    public static String sendPost(String url, String params) throws MalformedURLException,IOException{
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            java.net.URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");//"application/x-www-form-urlencoded; charset=UTF-8");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(params);
            // flush输出流的缓冲
            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
             in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += "" + line;
            }
        }
        // 关闭输出流、输入流
        finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
        return result;
    }
}
