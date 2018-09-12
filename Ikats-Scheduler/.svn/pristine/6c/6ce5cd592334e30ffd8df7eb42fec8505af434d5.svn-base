package com.ikats.scheduler.repository;

import java.util.List;
import java.util.Map;
import com.ikats.scheduler.entity.bean.PurchaseOrderBean;

/**
 * Repository
 * 
 * 入库单查询
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-21 14:04:57
 */
public interface IPurchaseOrderRepository {

    /** 添加单条记录 */
    int insert(PurchaseOrderBean record);

    /** 添加一批记录 */
    int insertList(List<PurchaseOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(PurchaseOrderBean record);

    /** 查询记录 - 根据主键 */
    PurchaseOrderBean selectByKey(Long id);

    /** 查询所有记录计数 */
    Long selectCount(Map<String, String> express);

    /** 筛选记录 */
    List<PurchaseOrderBean> selectByQuery(Map<String, String> express);

    /** 分页查询 */
    List<PurchaseOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express);

    /** 根据订单号修改 **/
    void updateByOrderNo(PurchaseOrderBean bean);

    List<PurchaseOrderBean> selectByNo(String orderNo);

    List<PurchaseOrderBean> getOrderSendJob();
}
