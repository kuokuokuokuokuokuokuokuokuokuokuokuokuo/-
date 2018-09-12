package com.ikats.scheduler.ibatis.mapper;

import com.ikats.scheduler.entity.bean.JSTOrderBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * Mapper
 * 
 * 聚水潭订单对接表Ibatis接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:12
 */
@Mapper
public interface JSTOrderMapper {

    /** 添加单条记录 */
    int insert(JSTOrderBean record);

    /** 添加一批记录 */
    int insertList(List<JSTOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(JSTOrderBean record);

    void updateByOrderNo(JSTOrderBean orderBean);

    /** 查询记录 - 根据主键 */
    JSTOrderBean selectByKey(Long id);

    List<JSTOrderBean> selectByNo(String orderNo);

    /** 查询所有记录计数 */
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<JSTOrderBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<JSTOrderBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<JSTOrderBean> getOrderSendJob();
}
