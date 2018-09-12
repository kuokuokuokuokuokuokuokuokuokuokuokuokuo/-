package com.ikats.scheduler.ibatis.mapper;


import com.ikats.scheduler.entity.bean.DmsSettlementRecordBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface DmsSettlementRecordMapper {

    // 添加单条记录
    int insert(DmsSettlementRecordBean record);

    int insertList(List<DmsSettlementRecordBean> list);

    //更新记录 - 根据主键
    int updateState(DmsSettlementRecordBean record);

    //查询记录 - 根据主键
    DmsSettlementRecordBean selectByKey(Long id);

    //分页查询
    List<DmsSettlementRecordBean> pageByQuery(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("express") Map<String, String> express);

    //查询所有的记录
    List<DmsSettlementRecordBean> selectAllRecord();

}
