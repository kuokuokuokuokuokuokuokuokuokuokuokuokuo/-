package com.ikats.scheduler.test;



import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

/**
 * post xml
 *
 * @Author : liu kuo
 * @Date : 2017/12/4 11:01.
 * @Description : Indulge in study , wasting away
 */
public class PostUtil {
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
    public static String sendPost(String url, String params){
        PrintWriter out = null;
        String result = "";
        try {
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", "application/xml;charset=UTF-8");
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
            result = conn.getResponseCode() + "";
        }catch (Exception e)
        {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }
        // 关闭输出流、输入流
        finally {
            if (out != null) {
                out.close();
            }
        }
        return result;
    }

    static void testPost(String urlStr, String xmlInfo) {
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Pragma:", "no-cache");
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");

            OutputStreamWriter out = new OutputStreamWriter(con
                    .getOutputStream());
            out.write(new String(xmlInfo.getBytes("ISO-8859-1")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con
                    .getInputStream()));
            String line = "";
            for (line = br.readLine(); line != null; line = br.readLine()) {
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String sendRequest(String url,String data){
        String strResponse;
        PostMethod method = new PostMethod(url);
        try {
            byte[] b = data.getBytes("UTF-8");
            InputStream is = new ByteArrayInputStream(b,0,b.length);
            RequestEntity re = new InputStreamRequestEntity(is,b.length,"text/plain; charset=utf-8");
            method.setRequestEntity(re);
            method.setRequestHeader("Content-Type","text/plain;charset=utf-8");
            HttpClient client = new HttpClient();
            int statusCode = client.executeMethod(method);
            if(statusCode == 200){
                strResponse = new String(method.getResponseBodyAsString().getBytes(),"UTF-8");
            }else{
                strResponse = "error1 : "+statusCode+".";
                System.out.println( "errorMsg : " + new String(method.getResponseBodyAsString().getBytes(),"UTF-8"));
            }
            method.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
            strResponse = "error2 : "+e.getMessage();
        }
        return strResponse;
    }
}