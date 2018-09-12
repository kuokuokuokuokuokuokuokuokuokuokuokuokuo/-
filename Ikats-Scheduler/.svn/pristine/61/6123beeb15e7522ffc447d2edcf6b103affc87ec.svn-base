package com.ikats.scheduler.ibatis.mapper;

import java.util.List;
import com.ikats.scheduler.entity.bean.CancelOrderBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * Mapper
 * 
 * 管易取消订单Ibatis接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-18 09:53:44
 */
@Mapper
public interface CancelOrderMapper {

    /** 添加单条记录 */
    int insert(CancelOrderBean record);

    /** 添加一批记录 */
    int insertList(List<CancelOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(CancelOrderBean record);

    /** 查询记录 - 根据主键 */
    CancelOrderBean selectByKey(Long id);

    /** 查询所有记录计数 */
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<CancelOrderBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<CancelOrderBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    int updateByOrderNo(CancelOrderBean bean);

    List<CancelOrderBean> selectByCode(String orderNo);

    List<CancelOrderBean> getOrderSendJob();
}
