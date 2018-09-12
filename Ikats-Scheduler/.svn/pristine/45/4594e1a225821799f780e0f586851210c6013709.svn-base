package com.ikats.scheduler.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author : liu kuo
 * @Date : 2017/12/4 14:29.
 * @Description : Indulge in study , wasting away
 */
public class OmsPostUtil {
    private static HttpURLConnection _conn = null;

    private static HttpURLConnection getConn() throws Exception
    {
        //测试环境
//        String omsPath = "http://ioms.t.esinotrans.com/eFreightHttpEngine";
        //怡和外网访问
//        String omsPath = "http://oms.adepotech.com:443/eFreightHttpEngine";
        //怡和内网访问 等价于 http://oms.adepotech.com/eFreightHttpEngine
//        String omsPath = "http://127.0.0.1:8080/esinotransoms/HttpEngine";
//        String omsPath = "http://127.0.0.1:8080/esinotransoms";
        String omsPath = "http://oms.adepotech.com/eFreightHttpEngine";
        URL url = new URL(omsPath);
        _conn = (HttpURLConnection) url.openConnection();
        _conn.setRequestProperty("Accept-Charset", "utf-8");
        _conn.setRequestProperty("contentType", "utf-8");
        _conn.setRequestMethod("POST");
        //超时时间 一分钟
        _conn.setConnectTimeout(60000);
        _conn.setDoOutput(true);
        return _conn;
    }

    public static String PostXml(String xml)
    {
        final String postXml = xml;
        String result = "";
        try
        {
            HttpURLConnection conn = getConn();
            StringBuffer params = new StringBuffer();
            params.append("serviceXml").append("=").append(URLEncoder.encode(postXml, "utf-8"));
            byte[] bypes = params.toString().getBytes();
            conn.getOutputStream().write(bypes);
            InputStream inStream = conn.getInputStream();
            result = new String(readInputStream(inStream), "utf-8");
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return result;
    }

    private static byte[] readInputStream(InputStream inStream) throws Exception
    {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }
}
