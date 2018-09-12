package com.ikats.scheduler.repository;

import java.util.List;
import java.util.Map;
import com.ikats.scheduler.entity.bean.CancelOrderBean;

/**
 * Repository
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
public interface ICancelOrderRepository {

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
    Long selectCount(Map<String, String> express);

    /** 筛选记录 */
    List<CancelOrderBean> selectByQuery(Map<String, String> express);

    /** 分页查询 */
    List<CancelOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express);

    List<CancelOrderBean> selectByCode(String orderNo);

    int updateByOrderNo(CancelOrderBean bean);

    List<CancelOrderBean> getOrderSendJob();
}
