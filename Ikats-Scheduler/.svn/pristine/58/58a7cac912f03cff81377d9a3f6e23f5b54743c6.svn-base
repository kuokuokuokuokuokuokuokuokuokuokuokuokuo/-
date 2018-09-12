package com.ikats.scheduler.ibatis.repository;

import java.util.List;
import java.util.Map;
import com.ikats.scheduler.entity.bean.CancelOrderBean;
import com.ikats.scheduler.ibatis.mapper.CancelOrderMapper;
import com.ikats.scheduler.repository.ICancelOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repository
 * 
 * 管易取消订单数据操作
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-18 09:53:44
 */
@Repository
public class CancelOrderRepository implements ICancelOrderRepository{

	@Autowired
	private CancelOrderMapper mapper;

    /** 添加单条记录 */
    @Override
    public int insert(CancelOrderBean record)
	{
		return mapper.insert(record);
	}

    /** 添加一批记录 */
    @Override
    public int insertList(List<CancelOrderBean> records)
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
    public int update(CancelOrderBean record)
	{
		return mapper.update(record);
	}

    /** 查询记录 - 根据主键 */
    @Override
    public CancelOrderBean selectByKey(Long id)
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
    public List<CancelOrderBean> selectByQuery(Map<String, String> express)
	{
		return mapper.selectByQuery(express);
	}

    /** 分页查询 */
    @Override
    public List<CancelOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
	{
		pageNum = pageSize * (pageNum - 1);
		return mapper.pageByQuery(pageNum,pageSize,express);
	}

	@Override
	public List<CancelOrderBean> selectByCode(String orderNo) {
		return this.mapper.selectByCode(orderNo);
	}

	@Override
	public int updateByOrderNo(CancelOrderBean bean) {
		return this.mapper.updateByOrderNo(bean);
	}

	@Override
	public List<CancelOrderBean> getOrderSendJob() {
		return this.mapper.getOrderSendJob();
	}
}
