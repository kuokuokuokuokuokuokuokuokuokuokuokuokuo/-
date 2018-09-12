package com.ikats.scheduler.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.ikats.scheduler.util.*;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;

/**
 * 四洲对接管易的测试main函数
 * @Author : liu kuo
 * @Date : 2018/5/3 16:07.
 * @Description : Indulge in study , wasting away
 */
public class SZGuanYiGetSkuRegisterMain
{
    private static String APP_KEY = "156484";
    private static String SECRET = "557c67476fc34c6bbac3d32d9340bfad";
    private static String SESSION_KEY = "6b4bb42b124a4cb780a4564e7ea7e20b";

    private static String FACE_NAME = "gy.erp.items.get";

    public static void main(String[] args) throws IOException
    {
        int index = 1;
        //获取到 appkey 对应的客户关系
        String clientXml = "<eFreightService>\n" +
                "<ServiceURL>Client</ServiceURL>\n" +
                "<ServiceAction>queryClient</ServiceAction>\n" +
                "<ServiceData>\n" +
                "<ChannelId/>\n" +
                "<AdminUserName>" + APP_KEY + "</AdminUserName>\n" +
                "<StockId/>\n" +
                "<ClientId/>\n" +
                "</ServiceData>\n" +
                "</eFreightService>\n";

        String clients = SZOmsPostUtil.PostXml(clientXml);
        System.out.println(clients);
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


        for (int page = 1; page < 10000; page++)
        {
//          Calendar now = Calendar.getInstance();
            JSONObject sendJson = new JSONObject();
            sendJson.put("appkey",APP_KEY);
            sendJson.put("sessionkey",SESSION_KEY);
            sendJson.put("method", FACE_NAME);
//          sendJson.put("end_date", sdf.format(new Date()));
//          sendJson.put("start_date", sdf.format(JobDateUtil.backToThePastMinute(now, 150).getTimeInMillis()));
//          sendJson.put("start_date", sdf.format(JobDateUtil.backToThePastDay(now, 2).getTimeInMillis()));
//          sendJson.put("code","LFQD0073-1");
            sendJson.put("page_no", page);
            sendJson.put("page_size", "100");
            String sendString = sendJson.toJSONString();
            String sign = SZGuanYiPostUtil.sign(sendString,SECRET);
            sendJson.put("sign", sign);
            String sendParam = sendJson.toJSONString();
            //管易回执
            String result = SZGuanYiPostUtil.sendPost(SZGuanYiPostUtil.URL, sendParam);
            JSONObject jsonGy = (JSONObject) JSONPath.read(result, "$");
            String success = jsonGy.getString("success");

            if (success.equals("false"))
            {
                return;
            }
            JSONArray items = (JSONArray) jsonGy.get("items");
            if (null == items || items.size() == 0)
            {
                System.out.println("----------------------- 商品备案查询无最新数据 ----------------------");
                break;
            }
            for (int i = 0; i < items.size(); i++)
            {
                JSONObject product = (JSONObject) items.get(i);
                String itemCode = product.getString("code");
                //是否为组合商品
                String combine = product.getString("combine");
                if (combine.equals("true"))//组合商品
                {
                    JSONArray combineItems = (JSONArray) product.get("combine_items");
                    //组合商品
                    String omsXml = "<Service>\n" +
                            "    <ServiceURL>GoodsRegister</ServiceURL>\n" +
                            "    <ServiceAction>saveGoodsRegister</ServiceAction>\n" +
                            "    <UserName></UserName>\n" +
                            "    <Platform></Platform>\n" +
                            "    <ChannelName></ChannelName>\n" +
                            "    <ServiceData>\n" +
                            "        <ClientID></ClientID>\n" +
                            "        <GoodsCode>" + product.getString("code") + "</GoodsCode>\n" +
                            "        <GoodsName>" + product.getString("name") + "</GoodsName>\n" +
                            "        <GoodsRoughWeight>" + product.getString("weight") + "</GoodsRoughWeight>\n" +
                            "        <GoodsPrice>" + product.getString("sales_price") + "</GoodsPrice>\n" +
                            "        <GoodsNetWeight>" + product.getString("weight") + "</GoodsNetWeight>\n" +
                            "        <Skus>\n";
                    for (int x = 0; x < combineItems.size(); x++)
                    {
                        JSONObject combineItem = (JSONObject) combineItems.get(x);
                        omsXml +=
                                "   <Sku>\n" +
                                        "       <SKUCode>" + combineItem.getString("item_code")+(StringUtils.isBlank(combineItem.getString("item_sku_code")) ? "" : "_" + combineItem.getString("item_sku_code")) +  "</SKUCode>\n" +
                                        "       <SKUCount>" + JobDataTransferUtil.stringToInt(combineItem.getString("qty")) + "</SKUCount>\n" +
                                        "       <MailTax>" + product.getString("tax_no") + "</MailTax>\n" +
                                        "       <ProductMarketingCountry>142</ProductMarketingCountry>\n" +
                                        "   </Sku>\n";
                    }
                    omsXml +=
                            "        </Skus>\n" +
                                    "    </ServiceData>\n" +
                                    "</Service>";

                    for(int h=0;h<client.size();h++)
                    {
                        JSONObject jClient = (JSONObject) client.get(h);
                        String clientId = jClient.getString("clientid");

                        omsXml = omsXml.replace("<UserName></UserName>","<UserName>" + clientId + "</UserName>");
                        omsXml = omsXml.replace("<ClientID></ClientID>","<ClientID>" + clientId + "</ClientID>");

                        String omsR = SZOmsPostUtil.PostXml(omsXml);
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println(index);
                        System.out.println(omsXml);
                        System.out.println(omsR);
                        System.out.println("------------------------------------------------------------------------------------------");
                        index++;
                    }

                } else {
                    //普通商品
                    JSONArray skus = (JSONArray) product.get("skus");
                    if(skus.size() == 0)//单一商品没有sku
                    {
                        //需要查一下barcode
                        JSONObject barJson = new JSONObject();
                        barJson.put("appkey",APP_KEY);
                        barJson.put("sessionkey",SESSION_KEY);
                        barJson.put("method", "gy.erp.item.barcode.get");
                        barJson.put("item_code",itemCode);
                        barJson.put("page_no",1);
                        barJson.put("page_size", "100");
                        String barString = barJson.toJSONString();
                        String barSign = SZGuanYiPostUtil.sign(barString,SECRET);
                        barJson.put("sign", barSign);
                        String barParam = barJson.toJSONString();
                        //管易回执
                        String abrResult = SZGuanYiPostUtil.sendPost(SZGuanYiPostUtil.URL, barParam);
                        JSONObject barGy = (JSONObject) JSONPath.read(abrResult, "$");
                        String barSucc = barGy.getString("success");
                        String barCode = "";
                        if(barSucc.equals("true"))
                        {
                            JSONArray barCodes = (JSONArray) barGy.get("barcode");
                            if(barCodes.size() > 0)
                            {
                                JSONObject barObject = (JSONObject)barCodes.get(0);
                                barCode = barObject.getString("barcode");
                            }
                        }
                        String omsXml =
                                "<Service>\n" +
                                        "  <ServiceURL>SKURegister</ServiceURL>\n" +
                                        "  <ServiceAction>TRANSACTION</ServiceAction>\n" +
                                        "  <ServiceData>\n" +
                                        "    <SKURegister>\n" +
                                        "      <ClientId></ClientId>\n" +
                                        "      <SKUCode>" + itemCode + "</SKUCode>\n" +
                                        "      <GoodsItemNo></GoodsItemNo>\n" +
                                        "      <SKUName>" + product.getString("name") + "</SKUName>\n" +
                                        "      <SKUPrice>" + product.getString("sales_price") + "</SKUPrice>\n" +
                                        "      <SKUCount></SKUCount>\n" +
                                        "      <SKUModel>" + product.getString("name") + "</SKUModel>\n" +
                                        "      <MailTaxNo>" + product.getString("tax_no") + "</MailTaxNo>\n" +
                                        "      <HsCode></HsCode>\n" +
                                        "      <WarehouseNo></WarehouseNo>\n" +
                                        "      <WarehouseLocation></WarehouseLocation>\n" +
                                        "      <DeclareMeasureUnit></DeclareMeasureUnit>\n" +
                                        "      <ProductionMarketingCountry></ProductionMarketingCountry>\n" +
                                        "      <GoodsNetWeight>" + product.getString("weight") + "</GoodsNetWeight>\n" +
                                        "      <GoodsRoughWeight>" + product.getString("weight") + "</GoodsRoughWeight>\n" +
                                        "      <Length></Length> \n  " +
                                        "      <Width></Width> \n  " +
                                        "      <Height></Height>\n" +
                                        "      <Description></Description>\n" +
                                        "      <LabelCode>" + barCode + "</LabelCode>\n" +
                                        "      <LabelCode1></LabelCode1>\n" +
                                        "      <LabelCode2></LabelCode2>\n" +
                                        "      <LabelCode3></LabelCode3>\n" +
                                        "      <SKUImageURL1>" + product.getString("pic_url") + "</SKUImageURL1>\n" +
                                        "      <SKUImageURL2></SKUImageURL2>\n" +
                                        "      <SKUImageURL3></SKUImageURL3>\n" +
                                        "      <SKUImageURL4></SKUImageURL4>\n" +
                                        "      <SKUImageURL5></SKUImageURL5>\n" +
                                        "      <FirstUnit></FirstUnit>\n" +
                                        "      <SecondUnit></SecondUnit>\n" +
                                        "     <Brand></Brand>\n" +
                                        "     <DueDays></DueDays>\n" +
                                        "    <WarningStock></WarningStock>\n" +
                                        "    </SKURegister>\n" +
                                        "  </ServiceData>\n" +
                                        "</Service>\n";

                        for(int h=0;h<client.size();h++)
                        {
                            JSONObject jClient = (JSONObject) client.get(h);
                            String clientId = jClient.getString("clientid");
                            String stockid = jClient.getString("stockid");

                            omsXml = omsXml.replace("<ClientId></ClientId>","<ClientId>" + clientId + "</ClientId>");//ClientId
                            omsXml = omsXml.replace("<WarehouseNo></WarehouseNo>","<WarehouseNo>" + stockid + "</WarehouseNo>");

                            String omsR = SZOmsPostUtil.PostXml(omsXml);
                            System.out.println("------------------------------------------------------------------------------------------");
                            System.out.println(index);
                            System.out.println(omsXml);
                            System.out.println(omsR);
                            System.out.println("------------------------------------------------------------------------------------------");
                            index++;
                        }

                    }else//有sku
                    {
                        for (int j = 0; j < skus.size(); j++)
                        {
                            JSONObject sku = (JSONObject) skus.get(j);
                            String skuCode = StringUtils.isBlank(sku.getString("code")) ? "" : "_" + sku.getString("code");

                            String omsXml =
                                    "<Service>\n" +
                                            "  <ServiceURL>SKURegister</ServiceURL>\n" +
                                            "  <ServiceAction>TRANSACTION</ServiceAction>\n" +
                                            "  <ServiceData>\n" +
                                            "    <SKURegister>\n" +
                                            "      <ClientId></ClientId>\n" +
                                            "      <SKUCode>" + itemCode + skuCode + "</SKUCode>\n" +
                                            "      <GoodsItemNo></GoodsItemNo>\n" +
                                            "      <SKUName>" + product.getString("name") + "</SKUName>\n" +
                                            "      <SKUPrice>" + sku.getString("sales_price") + "</SKUPrice>\n" +
                                            "      <SKUCount></SKUCount>\n" +
                                            "      <SKUModel>" + sku.getString("name") + "</SKUModel>\n" +
                                            "      <MailTaxNo>" + sku.getString("tax_no") + "</MailTaxNo>\n" +
                                            "      <HsCode></HsCode>\n" +
                                            "      <WarehouseNo></WarehouseNo>\n" +
                                            "      <WarehouseLocation></WarehouseLocation>\n" +
                                            "      <DeclareMeasureUnit></DeclareMeasureUnit>\n" +
                                            "      <ProductionMarketingCountry></ProductionMarketingCountry>\n" +
                                            "      <GoodsNetWeight>" + sku.getString("weight") + "</GoodsNetWeight>\n" +
                                            "      <GoodsRoughWeight>" + sku.getString("weight") + "</GoodsRoughWeight>\n" +
                                            "      <Length></Length> \n  " +
                                            "      <Width></Width> \n  " +
                                            "      <Height></Height>\n" +
                                            "      <Description></Description>\n" +
                                            "      <LabelCode>" + (sku.getString("bar_code") == null ? sku.getString("code") : sku.getString("bar_code")) + "</LabelCode>\n" +
                                            "      <LabelCode1></LabelCode1>\n" +
                                            "      <LabelCode2></LabelCode2>\n" +
                                            "      <LabelCode3></LabelCode3>\n" +
                                            "      <SKUImageURL1>" + product.getString("pic_url") + "</SKUImageURL1>\n" +
                                            "      <SKUImageURL2></SKUImageURL2>\n" +
                                            "      <SKUImageURL3></SKUImageURL3>\n" +
                                            "      <SKUImageURL4></SKUImageURL4>\n" +
                                            "      <SKUImageURL5></SKUImageURL5>\n" +
                                            "      <FirstUnit></FirstUnit>\n" +
                                            "      <SecondUnit></SecondUnit>\n" +
                                            "     <Brand></Brand>\n" +
                                            "     <DueDays></DueDays>\n" +
                                            "    <WarningStock></WarningStock>\n" +
                                            "    </SKURegister>\n" +
                                            "  </ServiceData>\n" +
                                            "</Service>\n";

                            for(int h=0;h<client.size();h++)
                            {
                                JSONObject jClient = (JSONObject) client.get(h);
                                String clientId = jClient.getString("clientid");
                                String stockid = jClient.getString("stockid");

                                omsXml = omsXml.replace("<ClientId></ClientId>","<ClientId>" + clientId + "</ClientId>");//ClientId
                                omsXml = omsXml.replace("<WarehouseNo></WarehouseNo>","<WarehouseNo>" + stockid + "</WarehouseNo>");

                                String omsR = SZOmsPostUtil.PostXml(omsXml);

                                System.out.println("------------------------------------------------------------------------------------------");
                                System.out.println(index);
                                System.out.println(omsXml);
                                System.out.println(omsR);
                                System.out.println("------------------------------------------------------------------------------------------");
                                index++;
                            }
                        }
                    }
                }
            }
            if (items.size() < 100) break;
        }

    }
}
