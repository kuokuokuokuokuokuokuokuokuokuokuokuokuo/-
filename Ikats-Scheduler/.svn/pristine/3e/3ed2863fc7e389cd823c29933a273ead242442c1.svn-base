package com.ikats.scheduler.repository;

import java.util.List;
import java.util.Map;
import com.ikats.scheduler.entity.bean.GYRecordBean;

/**
 * Repository
 * 
 * 管易对接的报文 , 数据记录表数据操作接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:01
 */
public interface IGYRecordRepository {

    /** 添加单条记录 */
    Long insert(GYRecordBean record);

    /** 添加一批记录 */
    int insertList(List<GYRecordBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(GYRecordBean record);

    /** 查询记录 - 根据主键 */
    GYRecordBean selectByKey(Long id);

    /** 查询所有记录计数 */
    Long selectCount(Map<String, String> express);

    /** 筛选记录 */
    List<GYRecordBean> selectByQuery(Map<String, String> express);

    /** 分页查询 */
    List<GYRecordBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express);

}
