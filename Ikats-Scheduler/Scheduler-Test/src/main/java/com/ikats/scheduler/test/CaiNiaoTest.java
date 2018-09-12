package com.ikats.scheduler.test;

import com.taobao.pac.sdk.cp.PacClient;
import com.taobao.pac.sdk.cp.SendSysParams;
import com.taobao.pac.sdk.cp.dataobject.request.TMS_WAYBILL_GET.*;
import com.taobao.pac.sdk.cp.dataobject.response.TMS_WAYBILL_GET.TmsWaybillGetResponse;
import com.taobao.pac.sdk.cp.dataobject.response.TMS_WAYBILL_GET.WaybillCloudPrintResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : liu kuo
 * @Date : 2017/12/29 11:16.
 * @Description : Indulge in study , wasting away
 */
public class CaiNiaoTest {

    /**
     * 测试环境 appKey
     */
    private final static String dailyAppKey = "966738";
    /**
     * 测试环境 secretKey
     */
    private final static String dailySecretKey = "085283e5H6643454549bGQ6D62848J00";

    private final static String dailyToken =
            "UDNpd1ZrQTNMTUFYeVFNc0JadmhqaXRTMjBuYzl0YktZcXpVTThvQ2N6ZDhtcXhmWGdFcU5wTXVpN3RtOXluQQ==";

    /**
     * 线上环境请求 url
     */
    private final static String onlineUrl = "http://link.cainiao.com/gateway/link.do";


    /**
     * 通过物流云获取电子面单
     *
     * @param args
     */
    public static void main(String[] args) {
        PacClient client = new PacClient(dailyAppKey, dailySecretKey, onlineUrl);
        SendSysParams params = new SendSysParams();
        params.setFromCode(dailyToken);

        TmsWaybillGetRequest request = new TmsWaybillGetRequest();
        // 配送公司编码
//        request.setCpCode("YTO");
        request.setCpCode("HTKY");

        // 发件人信息

        UserInfoDto sender = new UserInfoDto();
        request.setSender(sender);

        // 发件人姓名

        sender.setName("龚勤");
        // 发件人固定电话

        sender.setPhone("075486579222");
        // 发件人手机号

//        sender.setMobile("13000000000");

        // 寄件地址，这里的地址需要是卖家订购电子面单服务时使用的订购地址，具体可以通过 TMS_WAYBILL_SUBSCRIPTION_QUERY 接口获取

        AddressDto sendAddress = new AddressDto();
        sender.setAddress(sendAddress);
        sendAddress.setProvince("广东省");
        sendAddress.setCity("汕头市");
        sendAddress.setDistrict("潮阳区");
        sendAddress.setDetail("汕头市潮阳区谷饶镇茂广工业区 汕头市诸葛物流科技有限公司");

        String objectId = "A";
        // 收件信息

        ArrayList<TradeOrderInfoDto> tradeOrderInfoDtos = new ArrayList<TradeOrderInfoDto>();
        request.setTradeOrderInfoDtos(tradeOrderInfoDtos);

        TradeOrderInfoDto tradeOrderInfoDto = new TradeOrderInfoDto();
        tradeOrderInfoDto.setObjectId(objectId);
        String emsTemplateUrl = "http://cloudprint.cainiao.com/template/standard/501/130";//百世快递
//        String emsTemplateUrl = "http://cloudprint.cainiao.com/template/standard/101/572";//圆通
        // 打印模板的 url, 参见白皮书

        tradeOrderInfoDto.setTemplateUrl(emsTemplateUrl);
        tradeOrderInfoDtos.add(tradeOrderInfoDto);

        OrderInfoDto orderInfoDto = new OrderInfoDto();
        tradeOrderInfoDto.setOrderInfo(orderInfoDto);

        orderInfoDto.setOrderChannelsType("OTHERS");
        ArrayList<String> orderList = new ArrayList<String>();
        orderInfoDto.setTradeOrderList(orderList);

        // 订单列表，这里的场景是 一个订单获取一个面单号

        orderList.add("A12100129102019");

        PackageInfoDto packageInfoDto = new PackageInfoDto();
        tradeOrderInfoDto.setPackageInfo(packageInfoDto);
        ArrayList<Item> items = new ArrayList<Item>();
        packageInfoDto.setItems(items);
        Item item = new Item();
        items.add(item);
        item.setName("衣服");
        item.setCount(1);

        UserInfoDto receiver = new UserInfoDto();
        tradeOrderInfoDto.setRecipient(receiver);
        receiver.setName("收件人姓名");
        receiver.setMobile("13100000000");
        AddressDto receiveAddress = new AddressDto();
        receiver.setAddress(receiveAddress);

        receiveAddress.setProvince("浙江省");
        receiveAddress.setCity("杭州市");
        receiveAddress.setDistrict("余杭区");
        receiveAddress.setDetail("文一西路 969号");

        TmsWaybillGetResponse response = client.send(request, params);
        if (!response.isSuccess()) {
            System.out.println("errorCode:" + response.getErrorCode() + ",errorMessage:" + response.getErrorMsg());
            return;
        }
        List<WaybillCloudPrintResponse> waybillCloudPrintResponseList = response.getWaybillCloudPrintResponseList();
        for (WaybillCloudPrintResponse waybillCloudPrintResponse : waybillCloudPrintResponseList) {
            if (objectId.equals(waybillCloudPrintResponse.getObjectId())) {
                System.out.println("get waybillCode:" + waybillCloudPrintResponse.getWaybillCode() + ",printData:" +
                        waybillCloudPrintResponse.getPrintData());
                // 使用 printData 和 templateUrl  调用本地云打印组件打印面单
            }
        }
    }
}
