package com.ikats.scheduler.ibatis.mapper;

import java.util.List;
import com.ikats.scheduler.entity.bean.GYOrderBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * Mapper
 * 
 * 管易订单对接表Ibatis接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:12
 */
@Mapper
public interface GYOrderMapper {

    /** 添加单条记录 */
    int insert(GYOrderBean record);

    /** 添加一批记录 */
    int insertList(List<GYOrderBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(GYOrderBean record);

    void updateByOrderNo(GYOrderBean orderBean);

    /** 查询记录 - 根据主键 */
    GYOrderBean selectByKey(Long id);

    List<GYOrderBean> selectByNo(@Param("express") Map<String, String> express);

    /** 查询所有记录计数 */
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<GYOrderBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<GYOrderBean> pageByQuery(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<GYOrderBean> pageByQueryException(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<GYOrderBean> getOrderSendJob();
}
