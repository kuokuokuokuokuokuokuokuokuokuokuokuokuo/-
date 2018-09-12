package com.ikats.scheduler.controller;

import com.alibaba.fastjson.JSONObject;
import com.ikats.scheduler.entity.bean.GYOrderBean;
import com.ikats.scheduler.entity.bean.GYSkuBean;
import com.ikats.scheduler.entity.dto.OrderDto;
import com.ikats.scheduler.entity.enumerate.GYStatus;
import com.ikats.scheduler.entity.query.OrderQuery;
import com.ikats.scheduler.service.IGYOrderService;
import com.ikats.wharf.config.annotation.Reference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author : liu kuo
 * @Date : 2018/5/23 16:27.
 * @Description : Indulge in study , wasting away
 */
@Controller
@RequestMapping("Order")
public class OrderController
{

    @Reference(timeout = 30000)
    private IGYOrderService service;
    /**
     * 查找异常的订单
     * @param object
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "whole",method = {RequestMethod.POST})
    public OrderDto allExceptionOrder(@RequestBody JSONObject object)
    {
        OrderQuery query = new OrderQuery();
        Map<String,String> express = new HashMap<String, String>();
        if(StringUtils.isNotBlank(object.getString("orderNo")))
        {
            express.put("orderNo",object.getString("orderNo"));
        }
        String state = object.getString("state");
        if(StringUtils.isNotBlank(state))
        {
            if (state.equalsIgnoreCase("1"))
            {
                express.put("state",state);
            }
        }
        query.setExpress(express);
        return this.service.queryExceptionOrder(query);
    }

    /**
     * 重启订单发送 , 单个或全部异常订单
     * @param object
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "restart",method = {RequestMethod.POST})
    public OrderDto restartOrder(@RequestBody JSONObject object)
    {
        OrderQuery query = new OrderQuery();
        OrderDto result = new OrderDto();
        if(StringUtils.isNotBlank(object.getString("orderNo")))
        {
            result.setSuccess(false);
            result.setMessage("订单号缺失!");
            return result;
        }

        GYOrderBean bean = new GYOrderBean();
        bean.setOrderNo(object.getString("orderNo"));
        if(StringUtils.isNotBlank(object.getString("omsRequest")))
        {
            bean.setOmsRequest(object.getString("omsRequest"));
        }

        bean.setState(GYStatus.INIT.getValue());
        query.setDataRow(bean);
        return this.service.updateByOrderNo(query);
    }
}
