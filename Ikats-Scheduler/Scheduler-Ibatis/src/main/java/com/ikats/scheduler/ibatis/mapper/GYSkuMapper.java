package com.ikats.scheduler.ibatis.mapper;

import java.util.List;
import com.ikats.scheduler.entity.bean.GYSkuBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * Mapper
 * 
 * 管易商品对接表Ibatis接口
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 17:29:55
 */
@Mapper
public interface GYSkuMapper {

    /** 添加单条记录 */
    int insert(GYSkuBean record);

    /** 添加一批记录 */
    int insertList(List<GYSkuBean> records);

    /** 删除记录 - 根据主键 */
    int delete(Long id);

    /** 更新记录 - 根据主键 */
    int update(GYSkuBean record);

    int updateByCode(GYSkuBean bean);

    /** 查询记录 - 根据主键 */
    GYSkuBean selectByKey(Long id);

    List<GYSkuBean> selectByNo(String code);

    /** 查询所有记录计数 */
    Long selectCount(@Param("express") Map<String, String> express);

    /** 筛选记录 */
    List<GYSkuBean> selectByQuery(@Param("express") Map<String, String> express);

    /** 分页查询 */
    List<GYSkuBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    List<GYSkuBean> getSkuSendJob();
}
