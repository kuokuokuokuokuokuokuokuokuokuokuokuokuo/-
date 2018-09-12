package com.ikats.scheduler.service;

import com.ikats.scheduler.entity.dto.GYSkuDto;
import com.ikats.scheduler.entity.query.GYSkuQuery;

/**
 * Interface
 * 
 * 管易商品对接表
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 17:29:55
 */
public interface IGYSkuService {

	/**
	 * 服务接口:添加管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto insert(GYSkuQuery query);

	/**
	 * 服务接口:多行添加管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto insertList(GYSkuQuery query);

	/**
	 * 服务接口:删除管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto delete(GYSkuQuery query);

	/**
	 * 服务接口:更新管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto update(GYSkuQuery query);

	/**
	 * 服务接口:获取单行管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto selectByKey(GYSkuQuery query);

	/**
	 * 服务接口:计数所有管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto selectCount(GYSkuQuery query);

	/**
	 * 服务接口:查询管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto selectByQuery(GYSkuQuery query);

	/**
	 * 服务接口:翻页查询管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto pageByQuery(GYSkuQuery query);

}
