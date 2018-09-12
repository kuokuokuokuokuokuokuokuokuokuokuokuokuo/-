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
 * 聚水潭 配置和发送的工具
 * @Author : liu kuo
 * @Date : 2017/1/2
 * @Description : Indulge in study , wasting away
 */
public class JuShuiTanPostUtil
{
    //沙箱环境
//    public static String URL = "http://b.sursung.com/api/open/query.aspx";
//    public static String QM_URL = "http://a1q40taq0j.api.taobao.com/router/qmtest";

    //实际环境
    public static final String URL = "http://open.erp321.com/api/open/query.aspx";
    public static String QM_URL = "http://a1q40taq0j.api.taobao.com/router/qm";
    //测试账号
//    public static String PARTNER_ID = "ywv5jGT8ge6Pvlq3FZSPol345asd";
//    public static String PARTNER_KEY = "ywv5jGT8ge6Pvlq3FZSPol2323";
//    public static String TOKEN = "181ee8952a88f5a57db52587472c3798";
    //正式账号
    public static String PARTNER_ID = "705db2a02401606bd12bdc102acd035d";
    public static String PARTNER_KEY = "3d36040390695ae4a2e3f3161eb39fff";
    public static String TOKEN = "9f1bb3e1ba49355a17104eb44b6f31be";

    public static String TAO_KEY = "24743828";
    public static String TAO_SECRET = "b64bb5d33dcc0b09c730a4a39905f0cd";

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
