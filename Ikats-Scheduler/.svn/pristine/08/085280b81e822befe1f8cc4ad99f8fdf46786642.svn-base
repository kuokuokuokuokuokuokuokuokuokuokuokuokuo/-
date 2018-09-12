package com.ikats.scheduler.service;

import com.ikats.scheduler.logic.CancelOrderLogic;
import org.springframework.beans.factory.annotation.Autowired;
import com.ikats.wharf.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ikats.scheduler.entity.query.CancelOrderQuery;
import com.ikats.scheduler.entity.dto.CancelOrderDto;

/**
 * Service
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
@Transactional
@Service
public class CancelOrderService implements ICancelOrderService {

	@Autowired
	private CancelOrderLogic logic;
	
	/**
	 * 服务:添加管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto insert(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                logic.insert(query.getDataRow());
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("添加错误");
          }
          return result;
    }

	/**
	 * 服务:多行添加管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto insertList(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                logic.insertList(query.getDataTable());
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("添加错误");
          }
          return result;
    }

	/**
	 * 服务:删除管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto delete(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                logic.delete(query.getId());
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("删除错误");
          }
          return result;
    }

	/**
	 * 服务:更新管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto update(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                logic.update(query.getDataRow());
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("跟新错误");
          }
          return result;
    }

	/**
	 * 服务:获取单行管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto selectByKey(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                result.setDataRow(logic.selectByKey(query.getId()));
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("获取错误");
          }
          return result;
    }

	/**
	 * 服务:获取所有管易取消订单计数
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto selectCount(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                result.setCount(logic.selectCount(query.getExpress()));
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("获取错误");
          }
          return result;
    }

	/**
	 * 服务:查询管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto selectByQuery(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                result.setDataTable(logic.selectByQuery(query.getExpress()));
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("获取错误");
          }
          return result;
    }

	/**
	 * 服务:翻页查询管易取消订单
	 * @param query
	 * @return CancelOrderDto
	 */
	public CancelOrderDto pageByQuery(CancelOrderQuery query)
    {
        CancelOrderDto result = new CancelOrderDto();
        try{
                logic.clear();
                result.setDataTable(logic.pageByQuery(query.getPageNum(),query.getPageSize(),query.getExpress()));
                result.setCode(logic.getCode());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("获取错误");
          }
          return result;
    }

}
