package com.ikats.scheduler.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * 聚水潭使用奇门接口所需
 */
public class JSTOpenApi {

    protected  String HostUrl="http://a1q40taq0j.taobao.com/router/qm";

    public String partnerid;

    public String partnerkey;

    public String token;


    public long ts;

    /// <summary>
    ///  API接口名称
    /// </summary>
    public  String method;



    public Date timestamp = new Date();


    public Date getTimestamp() {
        return timestamp;
    }


    public  String QueryData() throws IOException
    {
        String sRes = "";
        String sUrl = "";
        HashMap<String, String> dicArg = new HashMap<String,String>();
        sUrl = GetRequestUrl(dicArg);
        sRes = PostData(sUrl, "");
        return sRes;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    protected  String format="json";

    protected String sign_method="md5";

    /// <summary>
    /// 版本号
    /// </summary>
    protected  String v="2.0";

    /// <summary>
    /// 第三方用户唯一凭证密钥，即secret
    /// </summary>
    public String Secret ;

    /// <summary>
    ///  分配给应用的AppKey，创建应用时可获得
    /// </summary>
    public String app_key;


    protected  String GetJstSignPara(HashMap<String, String> dicArg)
    {
        List<Entry<String,String>> list = new ArrayList<Entry<String,String>>(dicArg.entrySet());
        Collections.sort(list,new Comparator<Entry<String,String>>() {
            //升序排序
            public int compare(Entry<String, String> o1,
                               Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });


        StringBuilder prestr = new StringBuilder();

        for(Entry<String,String> mapping:list){
            if (mapping.getKey() == "sign" ||mapping.getKey()== "method" ||mapping.getKey() == "partnerid" ||mapping.getKey() == "jstsign" ||
                    mapping.getKey() == "timestamp" || mapping.getKey() == "app_key")
                continue;
            prestr.append(mapping.getKey() + mapping.getValue());
        }
        return prestr.toString();
    }

    /// <summary>
    /// 获取签名
    /// </summary>
    /// <returns></returns>
    protected String GetJstSign(HashMap<String, String> dicArg)
    {
        String sSign = this.method.replace("jst.", "") + partnerid + GetJstSignPara(dicArg) + partnerkey;
        return DoMD5(sSign);
    }

    /// <summary>
    /// 签名字符串
    /// </summary>
    /// <returns>签名结果</returns>
    protected String DoMD5(String prestr)
    {
        return JSTUtility.DoMD5(prestr,null);
    }


    /// <summary>
    /// 聚水潭签名
    /// </summary>
    public String jstsign;


    /// <summary>
    ///  对API输入参数进行md5加密获得，详细参考签名sign
    /// </summary>
    public String GetSign(HashMap<String, String> dicArg)
    {
        List<Entry<String,String>> list = new ArrayList<Entry<String,String>>(dicArg.entrySet());
        Collections.sort(list,new Comparator<Entry<String,String>>() {
            //升序排序
            @Override
            public int compare(Entry<String, String> o1,
                               Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });


        StringBuilder prestr = new StringBuilder();
        prestr.append(Secret);
        for(Entry<String,String> mapping:list){
            prestr.append(mapping.getKey());
            prestr.append(mapping.getValue());
        }
        prestr.append(Secret);
        System.out.println(prestr.toString());
        System.out.println(DoMD5(prestr.toString()).toUpperCase());
        return DoMD5(prestr.toString()).toUpperCase();
    }

    /// <summary>
    /// 初始化
    /// </summary>
    protected void Init(HashMap<String, String> dicArg)
    {
        if (dicArg == null)
        {
            dicArg = new HashMap<String, String>();
        }

        dicArg.put("token", token);

        if(dicArg.get("ts")==null)
        {
            dicArg.put("ts", String.valueOf(JSTUtility.GetStamp(new Date())));

        }
        dicArg.put("jstsign",  GetJstSign(dicArg));

        dicArg.put("app_key", app_key);
        dicArg.put("format", format);
        dicArg.put("method", method);
        dicArg.put("sign_method", sign_method);

        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

        dicArg.put("timestamp", formatter.format(getTimestamp()));
        dicArg.put("target_app_key", "23060081");
        dicArg.put("partnerid", partnerid);

        Iterator<Entry<String, String>> iterator = addArg.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            dicArg.put(entry.getKey(),entry.getValue());
        }
    }



    public HashMap<String, String> addArg =new HashMap<String, String>();

    public void AddArg(String sKey, String sValue)
    {
        addArg.put(sKey,sValue);
    }

    public  String GetRequestUrl(HashMap<String, String> dicArg) throws UnsupportedEncodingException
    {
        Init(dicArg);
        dicArg.put("sign", GetSign(dicArg));

        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(HostUrl);
        Boolean isFirst=true;
        Iterator<Entry<String, String>> iterator = dicArg.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            if(isFirst)
            {
                sbUrl.append("?");
            }
            else
            {
                sbUrl.append("&");
            }
            sbUrl.append(entry.getKey());
            sbUrl.append("=");
            sbUrl.append(URLEncoder.encode(entry.getValue(),"UTF-8"));
            isFirst=false;
        }
        System.out.println(sbUrl.toString());
        return sbUrl.toString();
    }




    /// <summary>
    /// POST数据
    /// </summary>
    /// <param name="sContent"></param>
    /// <returns></returns>
    protected  String PostData(String sUrl, String sContent) throws IOException
    {
        if (sContent==null|| StringUtils.isBlank(sContent))
        {
            return JSTUtility.PostData(sUrl, "");
        }
        else
        {
            return JSTUtility.PostData(sUrl, sContent);
        }
    }

    /// <summary>
    /// 基于此类的所有方法入口
    /// </summary>
    /// <returns></returns>
    public String Execute()
    {
        String sRes = "";
        try
        {
            Validate();
            if (!IsSuccess)
            {
                return null;
            }
            else
            {
                String sUrl = GetRequestUrl(null);
                sRes = PostData(sUrl, null);
                return sRes;
            }
        }
        catch (Exception e2)
        {
            this.Msg = e2.toString();
            this.IsSuccess = false;
            return null;
        }

    }

    /// <summary>
    /// 验证数据规范性
    /// </summary>
    public  void Validate()
    {

    }

    private Boolean IsSuccess = true;


    public String Msg;


    /// <summary>
    /// 返回的数据,对象类型
    /// </summary>
    public String ReturnData;

}
