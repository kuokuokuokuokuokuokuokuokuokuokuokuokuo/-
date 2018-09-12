package com.ikats.scheduler.repository;

import com.ikats.scheduler.entity.bean.JSTSkuBean;

import java.util.List;
import java.util.Map;

/**
 * Repository
 * 
 * 聚水潭商品对接表数据操作接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 17:29:55
 */
public interface IJSTSkuRepository {

    /** 添加单条记录 */
    int insert(JSTSkuBean record);

    /** 添加一批记录 */
    int insertList(List<JSTSkuBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(JSTSkuBean record);

    int updateByCode(JSTSkuBean bean);

    /** 查询记录 - 根据主键 */
    JSTSkuBean selectByKey(Long id);

    List<JSTSkuBean> selectByNo(String code);

    /** 查询所有记录计数 */
    Long selectCount(Map<String, String> express);

    /** 筛选记录 */
    List<JSTSkuBean> selectByQuery(Map<String, String> express);

    /** 分页查询 */
    List<JSTSkuBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express);

    List<JSTSkuBean> getSkuSendJob();
}
