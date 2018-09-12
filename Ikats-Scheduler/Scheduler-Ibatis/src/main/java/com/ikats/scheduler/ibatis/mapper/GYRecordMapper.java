package com.ikats.scheduler.ibatis.mapper;

import java.util.List;
import com.ikats.scheduler.entity.bean.GYRecordBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * Mapper
 * 
 * 管易对接的报文 , 数据记录表Ibatis接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:01
 */
@Mapper
public interface GYRecordMapper {

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
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<GYRecordBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<GYRecordBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

}
