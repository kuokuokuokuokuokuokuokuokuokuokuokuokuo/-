package com.ikats.scheduler.repository;

import com.ikats.scheduler.entity.bean.JSTPurchaseOrderBean;

import java.util.List;
import java.util.Map;

/**
 * Repository
 * 
 * 聚水潭订单对接表数据操作接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:12
 */
public interface IJSTPurchaseOrderRepository {

    /** 添加单条记录 */
    int insert(JSTPurchaseOrderBean record);

    /** 添加一批记录 */
    int insertList(List<JSTPurchaseOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(JSTPurchaseOrderBean record);

    /** 查询记录 - 根据主键 */
    JSTPurchaseOrderBean selectByKey(Long id);

    /** 查询所有记录计数 */
    Long selectCount(Map<String, String> express);

    /** 筛选记录 */
    List<JSTPurchaseOrderBean> selectByQuery(Map<String, String> express);

    /** 分页查询 */
    List<JSTPurchaseOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express);

    /** 根据订单号修改 **/
    void updateByOrderNo(JSTPurchaseOrderBean bean);

    List<JSTPurchaseOrderBean> selectByNo(String orderNo);

    List<JSTPurchaseOrderBean> getOrderSendJob();
}
