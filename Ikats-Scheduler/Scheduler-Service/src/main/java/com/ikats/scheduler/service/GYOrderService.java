package com.ikats.scheduler.service;

import com.ikats.scheduler.logic.GYOrderLogic;
import com.ikats.wharf.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.ikats.scheduler.entity.query.OrderQuery;
import com.ikats.scheduler.entity.dto.OrderDto;


@Transactional
@Service
public class GYOrderService implements IGYOrderService {

	@Autowired
	private GYOrderLogic logic;
	
	/**
	 * 服务:添加管易订单对接表
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto insert(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                logic.insert(query.getDataRow());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("添加错误");
          }
          return result;
    }

	/**
	 * 服务:多行添加管易订单对接表
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto insertList(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                logic.insertList(query.getDataTable());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("添加错误");
          }
          return result;
    }

	/**
	 * 服务:删除管易订单对接表
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto delete(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                logic.delete(query.getId());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("删除错误");
          }
          return result;
    }

	/**
	 * 服务:更新管易订单对接表
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto update(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                logic.update(query.getDataRow());
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("跟新错误");
          }
          return result;
    }

    @Override
    public OrderDto updateByOrderNo(OrderQuery query) {
        OrderDto result = new OrderDto();
        try{
            logic.clear();
            logic.updateByOrderNo(query.getDataRow());
            result.setSuccess(logic.getSuccess());
            result.setMessage(logic.getMessage());
        }catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("跟新错误");
        }
        return result;
    }

    /**
	 * 服务:获取单行管易订单对接表
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto selectByKey(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                result.setDataRow(logic.selectByKey(query.getId()));
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("获取错误");
          }
          return result;
    }

	/**
	 * 服务:获取所有管易订单对接表计数
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto selectCount(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                result.setCount(logic.selectCount(query.getExpress()));
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("获取错误");
          }
          return result;
    }

	/**
	 * 服务:查询管易订单对接表
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto selectByQuery(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                result.setDataTable(logic.selectByQuery(query.getExpress()));
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex) {
            result.setSuccess(false);
            result.setMessage("获取错误");
        }
        return result;
    }

	/**
	 * 服务:翻页查询管易订单对接表
	 * @param query
	 * @return OrderDto
	 */
	public OrderDto pageByQuery(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
                logic.clear();
                result.setDataTable(logic.pageByQuery(query.getPageNum(),query.getPageSize(),query.getExpress()));
                result.setSuccess(logic.getSuccess());
                result.setMessage(logic.getMessage());
         }catch (Exception ex){
                result.setSuccess(false);
                result.setMessage("获取错误");
          }
          return result;
    }

    public OrderDto queryExceptionOrder(OrderQuery query)
    {
        OrderDto result = new OrderDto();
        try{
            logic.clear();
            result.setDataTable(logic.queryExceptionOrder(query.getPageNum(),query.getPageSize(),query.getExpress()));
            result.setSuccess(logic.getSuccess());
            result.setMessage(logic.getMessage());
        }catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("获取错误");
        }
        return result;
    }
}
