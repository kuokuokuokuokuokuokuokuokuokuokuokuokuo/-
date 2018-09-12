package com.ikats.scheduler.test;


public class Query extends OpenApi {
	  public Query(String sAppKey,String sAppSecret,String sPartnerId,String sPartnerKey,String stoken ,String sRequestName,String sHostUrl)
	  {
		  this.partnerid=sPartnerId;
		  this.partnerkey=sPartnerKey;
		  this.method=sRequestName;
		  this.HostUrl=sHostUrl;
		  this.token=stoken;
		  this.app_key=sAppKey;
		  this.Secret=sAppSecret;
	  }
}