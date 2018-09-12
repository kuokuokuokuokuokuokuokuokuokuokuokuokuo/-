package com.ikats.scheduler.ibatis.repository;

import java.util.List;
import java.util.Map;

import com.ikats.scheduler.entity.bean.GYRecordBean;
import com.ikats.scheduler.ibatis.mapper.GYRecordMapper;
import com.ikats.scheduler.repository.IGYRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repository
 * 
 * 管易对接的报文 , 数据记录表数据操作
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:01
 */
@Repository
public class GYRecordRepository implements IGYRecordRepository {

	@Autowired
	private GYRecordMapper mapper;

    /** 添加单条记录 */
    @Override
    public Long insert(GYRecordBean record)
	{
		return mapper.insert(record);
	}

    /** 添加一批记录 */
    @Override
    public int insertList(List<GYRecordBean> records)
	{
		return mapper.insertList(records);
	}

    /** 删除记录 - 根据主键 */
    @Override
    public int delete(Long id)
	{
		return mapper.delete(id);
	}

    /** 更新记录 - 根据主键 */
    @Override
    public int update(GYRecordBean record)
	{
		return mapper.update(record);
	}

    /** 查询记录 - 根据主键 */
    @Override
    public GYRecordBean selectByKey(Long id)
	{
		return mapper.selectByKey(id);
	}

    /** 所有记录计数 */
    @Override
    public Long selectCount(Map<String, String> express)
	{
		return mapper.selectCount(express);
	}

    /** 筛选记录 */
    @Override
    public List<GYRecordBean> selectByQuery(Map<String, String> express)
	{
		return mapper.selectByQuery(express);
	}

    /** 分页查询 */
    @Override
    public List<GYRecordBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
	{
		pageNum = pageSize * (pageNum - 1);
		return mapper.pageByQuery(pageNum,pageSize,express);
	}

}
