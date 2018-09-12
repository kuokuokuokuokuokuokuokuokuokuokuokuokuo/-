package com.ikats.scheduler.ibatis.repository;

import com.ikats.scheduler.entity.bean.JSTSkuBean;
import com.ikats.scheduler.ibatis.mapper.JSTSkuMapper;
import com.ikats.scheduler.repository.IJSTSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Repository
 * 
 * 聚水潭商品对接表数据操作
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 17:29:55
 */
@Repository
public class JSTSkuRepository implements IJSTSkuRepository{

	@Autowired
	private JSTSkuMapper mapper;

    /** 添加单条记录 */
    @Override
    public int insert(JSTSkuBean record)
	{
		return mapper.insert(record);
	}

    /** 添加一批记录 */
    @Override
    public int insertList(List<JSTSkuBean> records)
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
    public int update(JSTSkuBean record)
	{
		return mapper.update(record);
	}

	@Override
	public int updateByCode(JSTSkuBean bean) {
		return this.mapper.updateByCode(bean);
	}

	/** 查询记录 - 根据主键 */
    @Override
    public JSTSkuBean selectByKey(Long id)
	{
		return mapper.selectByKey(id);
	}

	@Override
	public List<JSTSkuBean> selectByNo(String code) {
		return this.mapper.selectByNo(code);
	}

	/** 所有记录计数 */
    @Override
    public Long selectCount(Map<String, String> express)
	{
		return mapper.selectCount(express);
	}

    /** 筛选记录 */
    @Override
    public List<JSTSkuBean> selectByQuery(Map<String, String> express)
	{
		return mapper.selectByQuery(express);
	}

    /** 分页查询 */
    @Override
    public List<JSTSkuBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
	{
		pageNum = pageSize * (pageNum - 1);
		return mapper.pageByQuery(pageNum,pageSize,express);
	}

	@Override
	public List<JSTSkuBean> getSkuSendJob()
	{
		return this.mapper.getSkuSendJob();
	}
}
