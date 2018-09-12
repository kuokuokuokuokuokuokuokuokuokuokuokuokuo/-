package com.ikats.scheduler.ibatis.mapper;

import com.ikats.scheduler.entity.bean.JSTAllocateBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Jianzhen
 * @Date: Created in 10:22 2018/1/4
 * @Description:
 */
@Mapper
public interface JSTAllocateMapper {


    /** 添加单条记录 */
    int insert(JSTAllocateBean record);

    /** 添加一批记录 */
    int insertList(List<JSTAllocateBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(JSTAllocateBean record);

    void updateByoutboundId(JSTAllocateBean orderBean);

    /** 查询记录 - 根据主键 */
    JSTAllocateBean selectByKey(Long id);

    List<JSTAllocateBean> selectByNo(String orderNo);

    /** 查询所有记录计数 */
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<JSTAllocateBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<JSTAllocateBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<JSTAllocateBean> getAllocateSendJob();
    
}
