package com.ikats.scheduler.repository;

import com.ikats.scheduler.entity.bean.JSTAllocateBean;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Jianzhen
 * @Date: Created in 10:28 2018/1/4
 * @Description:
 */
public interface IJSTAllocateRepository {


    /** 添加单条记录 */
    int insert(JSTAllocateBean record);

    /** 添加一批记录 */
    int insertList(List<JSTAllocateBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(JSTAllocateBean record);

    /** 查询记录 - 根据主键 */
    JSTAllocateBean selectByKey(Long id);

    /** 查询所有记录计数 */
    Long selectCount(Map<String, String> express);

    /** 筛选记录 */
    List<JSTAllocateBean> selectByQuery(Map<String, String> express);

    /** 分页查询 */
    List<JSTAllocateBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express);

    /** 根据订单号修改 **/
    void updateByoutboundId(JSTAllocateBean bean);

    List<JSTAllocateBean> selectByNo(String orderNo);

    List<JSTAllocateBean> getAllocateSendJob();
    
}
