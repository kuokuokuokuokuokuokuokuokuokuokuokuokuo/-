package com.ikats.scheduler.ibatis.repository;

import com.ikats.scheduler.entity.bean.JSTCancelOrderBean;
import com.ikats.scheduler.ibatis.mapper.JSTCancelOrderMapper;
import com.ikats.scheduler.repository.IJSTCancelOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Repository
 * 
 * 聚水潭取消订单数据操作
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-18 09:53:44
 */
@Repository
public class JSTCancelOrderRepository implements IJSTCancelOrderRepository{

	@Autowired
	private JSTCancelOrderMapper mapper;

    /** 添加单条记录 */
    @Override
    public int insert(JSTCancelOrderBean record)
	{
		return mapper.insert(record);
	}

    /** 添加一批记录 */
    @Override
    public int insertList(List<JSTCancelOrderBean> records)
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
    public int update(JSTCancelOrderBean record)
	{
		return mapper.update(record);
	}

    /** 查询记录 - 根据主键 */
    @Override
    public JSTCancelOrderBean selectByKey(Long id)
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
    public List<JSTCancelOrderBean> selectByQuery(Map<String, String> express)
	{
		return mapper.selectByQuery(express);
	}

    /** 分页查询 */
    @Override
    public List<JSTCancelOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
	{
		pageNum = pageSize * (pageNum - 1);
		return mapper.pageByQuery(pageNum,pageSize,express);
	}

	@Override
	public List<JSTCancelOrderBean> selectByCode(String orderNo) {
		return this.mapper.selectByCode(orderNo);
	}

	@Override
	public int updateByOrderNo(JSTCancelOrderBean bean) {
		return this.mapper.updateByOrderNo(bean);
	}

	@Override
	public List<JSTCancelOrderBean> getOrderSendJob() {
		return this.mapper.getOrderSendJob();
	}
}
