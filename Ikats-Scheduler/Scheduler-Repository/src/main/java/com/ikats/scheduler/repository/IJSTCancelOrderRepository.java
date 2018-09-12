package com.ikats.scheduler.repository;

import com.ikats.scheduler.entity.bean.JSTCancelOrderBean;

import java.util.List;
import java.util.Map;

/**
 * Repository
 * 
 * 聚水潭取消订单
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-18 09:53:44
 */
public interface IJSTCancelOrderRepository {

    /** 添加单条记录 */
    int insert(JSTCancelOrderBean record);

    /** 添加一批记录 */
    int insertList(List<JSTCancelOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(JSTCancelOrderBean record);

    /** 查询记录 - 根据主键 */
    JSTCancelOrderBean selectByKey(Long id);

    /** 查询所有记录计数 */
    Long selectCount(Map<String, String> express);

    /** 筛选记录 */
    List<JSTCancelOrderBean> selectByQuery(Map<String, String> express);

    /** 分页查询 */
    List<JSTCancelOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express);

    List<JSTCancelOrderBean> selectByCode(String orderNo);

    int updateByOrderNo(JSTCancelOrderBean bean);

    List<JSTCancelOrderBean> getOrderSendJob();
}
