package com.ikats.scheduler.service;

import com.ikats.scheduler.logic.GYSkuLogic;
import com.ikats.wharf.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.ikats.scheduler.entity.query.GYSkuQuery;
import com.ikats.scheduler.entity.dto.GYSkuDto;


@Transactional
@Service
public class GYSkuService implements IGYSkuService {

	@Autowired
	private GYSkuLogic logic;
	
	/**
	 * 服务:添加管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto insert(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
	 * 服务:多行添加管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto insertList(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
	 * 服务:删除管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto delete(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
	 * 服务:更新管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto update(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
	 * 服务:获取单行管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto selectByKey(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
	 * 服务:获取所有管易商品对接表计数
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto selectCount(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
	 * 服务:查询管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto selectByQuery(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
	 * 服务:翻页查询管易商品对接表
	 * @param query
	 * @return SkuDto
	 */
	public GYSkuDto pageByQuery(GYSkuQuery query)
    {
        GYSkuDto result = new GYSkuDto();
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
