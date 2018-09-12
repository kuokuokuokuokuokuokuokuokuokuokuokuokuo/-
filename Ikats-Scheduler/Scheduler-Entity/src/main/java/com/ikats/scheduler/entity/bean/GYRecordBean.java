package com.ikats.scheduler.entity.bean;


import java.io.Serializable;
import java.util.Date;

/**
 * Bean
 * 
 * 管易对接的报文 , 数据记录表实体类
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:01
 */
public class GYRecordBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String gyRequest;

	private String gyResponse;

	private String appKey;

	private String success;

	private String face;

	private Date createTime;

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGyRequest() {
		return this.gyRequest;
	}

	public void setGyRequest(String gyRequest) {
		this.gyRequest = gyRequest;
	}

	public String getGyResponse() {
		return this.gyResponse;
	}

	public void setGyResponse(String gyResponse) {
		this.gyResponse = gyResponse;
	}

	public String getAppKey() {
		return this.appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}