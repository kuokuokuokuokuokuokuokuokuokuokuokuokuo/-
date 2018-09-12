package com.ikats.scheduler.entity.bean;

import java.util.Date;

/**
 * 聚水潭商品对接表实体类
 *
 * @Author: Zhao Jianzhen
 * @Date: Created in 9:52 2018/1/3
 * @Description:
 */
public class JSTSkuBean implements java.io.Serializable{


    private static final long serialVersionUID = 1L;

    private Long id;

    private String skuCode;

    private String appKey;

    /** 订单状态 , 0 : 初始化 ; 1 : 已处理 ; 2 : 处理异常(发送5次后仍失败) */
    private String state;

    private Integer times;

    /** 像oms发送的报文 */
    private String omsRequest;

    /** oms回执的报文 */
    private String omsResponse;

    private Date createTime;

    private Date sendTime;

    private Date returnTime;

    private String combine;

    public String getCombine() {
        return combine;
    }

    public void setCombine(String combine) {
        this.combine = combine;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkuCode() {
        return this.skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * 获得 订单状态 , 0 : 初始化 ; 1 : 已处理 ; 2 : 处理异常(发送5次后仍失败)
     *
     * @return 订单状态 , 0 : 初始化 ; 1 : 已处理 ; 2 : 处理异常(发送5次后仍失败)
     */
    public String getState() {
        return this.state;
    }

    /**
     * 设置 订单状态 , 0 : 初始化 ; 1 : 已处理 ; 2 : 处理异常(发送5次后仍失败)
     *
     * @param state 订单状态 , 0 : 初始化 ; 1 : 已处理 ; 2 : 处理异常(发送5次后仍失败)
     */
    public void setState(String state) {
        this.state = state;
    }

    public Integer getTimes() {
        return this.times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * 获得 像oms发送的报文
     *
     * @return 像oms发送的报文
     */
    public String getOmsRequest() {
        return this.omsRequest;
    }

    /**
     * 设置 像oms发送的报文
     *
     * @param omsRequest 像oms发送的报文
     */
    public void setOmsRequest(String omsRequest) {
        this.omsRequest = omsRequest;
    }

    /**
     * 获得 oms回执的报文
     *
     * @return oms回执的报文
     */
    public String getOmsResponse() {
        return this.omsResponse;
    }

    /**
     * 设置 oms回执的报文
     *
     * @param omsResponse oms回执的报文
     */
    public void setOmsResponse(String omsResponse) {
        this.omsResponse = omsResponse;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
