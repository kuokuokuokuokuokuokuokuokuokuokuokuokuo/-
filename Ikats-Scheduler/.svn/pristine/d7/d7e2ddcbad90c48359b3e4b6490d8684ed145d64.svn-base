package com.ikats.scheduler.ibatis.mapper;

import java.util.List;
import com.ikats.scheduler.entity.bean.PurchaseOrderBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * Mapper
 * 
 * 入库单查询Ibatis接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-21 14:04:57
 */
@Mapper
public interface PurchaseOrderMapper {

    /** 添加单条记录 */
    int insert(PurchaseOrderBean record);

    /** 添加一批记录 */
    int insertList(List<PurchaseOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(PurchaseOrderBean record);

    void updateByOrderNo(PurchaseOrderBean record);

    /** 查询记录 - 根据主键 */
    PurchaseOrderBean selectByKey(Long id);

    List<PurchaseOrderBean> selectByNo(String orderNo);

    /** 查询所有记录计数 */
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<PurchaseOrderBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<PurchaseOrderBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<PurchaseOrderBean> getOrderSendJob();
}
