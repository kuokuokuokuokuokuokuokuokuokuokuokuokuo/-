package com.ikats.scheduler.ibatis.mapper;

import com.ikats.scheduler.entity.bean.JSTPurchaseOrderBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * 聚水潭采购单对接表Ibatis接口
 *
 * @Author: Zhao Jianzhen
 * @Date: Created in 13:56 2018/1/3
 * @Description:
 */
@Mapper
public interface JSTPurchaseOrderMapper {

    /** 添加单条记录 */
    int insert(JSTPurchaseOrderBean record);

    /** 添加一批记录 */
    int insertList(List<JSTPurchaseOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(JSTPurchaseOrderBean record);

    void updateByOrderNo(JSTPurchaseOrderBean orderBean);

    /** 查询记录 - 根据主键 */
    JSTPurchaseOrderBean selectByKey(Long id);

    List<JSTPurchaseOrderBean> selectByNo(String orderNo);

    /** 查询所有记录计数 */
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<JSTPurchaseOrderBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<JSTPurchaseOrderBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<JSTPurchaseOrderBean> getOrderSendJob();
}
