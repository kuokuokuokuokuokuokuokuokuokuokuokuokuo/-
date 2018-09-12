package com.ikats.scheduler.service;
import com.ikats.scheduler.entity.dto.CancelOrderDto;
import com.ikats.scheduler.entity.query.CancelOrderQuery;

/**
 * Interface
 * 
 * 管易取消订单
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-18 09:53:44
 */
public interface ICancelOrderService {

	/**
	 * 服务接口:添加管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto insert(CancelOrderQuery query);

	/**
	 * 服务接口:多行添加管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto insertList(CancelOrderQuery query);

	/**
	 * 服务接口:删除管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto delete(CancelOrderQuery query);

	/**
	 * 服务接口:更新管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto update(CancelOrderQuery query);

	/**
	 * 服务接口:获取单行管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto selectByKey(CancelOrderQuery query);

	/**
	 * 服务接口:计数所有管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto selectCount(CancelOrderQuery query);

	/**
	 * 服务接口:查询管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto selectByQuery(CancelOrderQuery query);

	/**
	 * 服务接口:翻页查询管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto pageByQuery(CancelOrderQuery query);

}
