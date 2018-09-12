package com.ikats.scheduler.ibatis.repository;

import com.ikats.scheduler.entity.bean.JSTOrderBean;
import com.ikats.scheduler.ibatis.mapper.JSTOrderMapper;
import com.ikats.scheduler.repository.IJSTOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Repository
 * 
 * 聚水潭订单对接表数据操作
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-05 09:31:12
 */
@Repository
public class JSTOrderRepository implements IJSTOrderRepository{

	@Autowired
	private JSTOrderMapper mapper;

    /** 添加单条记录 */
    @Override
    public int insert(JSTOrderBean record)
	{
		return mapper.insert(record);
	}

    /** 添加一批记录 */
    @Override
    public int insertList(List<JSTOrderBean> records)
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
    public int update(JSTOrderBean record)
	{
		return mapper.update(record);
	}

    /** 查询记录 - 根据主键 */
    @Override
    public JSTOrderBean selectByKey(Long id)
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
    public List<JSTOrderBean> selectByQuery(Map<String, String> express)
	{
		return mapper.selectByQuery(express);
	}

    /** 分页查询 */
    @Override
    public List<JSTOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
	{
		pageNum = pageSize * (pageNum - 1);
		return mapper.pageByQuery(pageNum,pageSize,express);
	}

	@Override
	public void updateByOrderNo(JSTOrderBean bean)
	{
		this.mapper.updateByOrderNo(bean);
	}

	@Override
	public List<JSTOrderBean> selectByNo(String orderNo) {
		return this.mapper.selectByNo(orderNo);
	}

	@Override
	public List<JSTOrderBean> getOrderSendJob() {
		return this.mapper.getOrderSendJob();
	}
}
