package com.ikats.scheduler.ibatis.mapper;

import com.ikats.scheduler.entity.bean.JSTSkuBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Jianzhen
 * @Date: Created in 9:58 2018/1/3
 * @Description:
 */
@Mapper
public interface JSTSkuMapper {

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
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<JSTSkuBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<JSTSkuBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<JSTSkuBean> getSkuSendJob();
}
