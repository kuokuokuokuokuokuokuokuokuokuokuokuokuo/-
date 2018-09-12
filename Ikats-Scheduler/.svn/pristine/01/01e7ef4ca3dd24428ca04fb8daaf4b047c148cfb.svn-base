package com.ikats.scheduler.ibatis.repository;

import java.util.List;
import java.util.Map;
import com.ikats.scheduler.ibatis.mapper.PurchaseOrderMapper;
import com.ikats.scheduler.repository.IPurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.ikats.scheduler.entity.bean.PurchaseOrderBean;
import org.springframework.stereotype.Repository;

/**
 * Repository
 * 
 * 入库单查询数据操作
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-21 14:04:57
 */
@Repository
public class PurchaseOrderRepository implements IPurchaseOrderRepository{

	@Autowired
	private PurchaseOrderMapper mapper;

    /** 添加单条记录 */
    @Override
    public int insert(PurchaseOrderBean record)
	{
		return mapper.insert(record);
	}

    /** 添加一批记录 */
    @Override
    public int insertList(List<PurchaseOrderBean> records)
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
    public int update(PurchaseOrderBean record)
	{
		return mapper.update(record);
	}

    /** 查询记录 - 根据主键 */
    @Override
    public PurchaseOrderBean selectByKey(Long id)
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
    public List<PurchaseOrderBean> selectByQuery(Map<String, String> express)
	{
		return mapper.selectByQuery(express);
	}

    /** 分页查询 */
    @Override
    public List<PurchaseOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
	{
		pageNum = pageSize * (pageNum - 1);
		return mapper.pageByQuery(pageNum,pageSize,express);
	}

	@Override
	public void updateByOrderNo(PurchaseOrderBean bean) {
		this.mapper.updateByOrderNo(bean);
	}

	@Override
	public List<PurchaseOrderBean> selectByNo(String orderNo) {
		return this.mapper.selectByNo(orderNo);
	}

	@Override
	public List<PurchaseOrderBean> getOrderSendJob() {
		return this.mapper.getOrderSendJob();
	}
}
