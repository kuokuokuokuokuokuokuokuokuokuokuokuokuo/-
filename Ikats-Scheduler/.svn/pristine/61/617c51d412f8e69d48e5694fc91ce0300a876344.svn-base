package com.ikats.scheduler.logic;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.ikats.scheduler.entity.bean.CancelOrderBean;
import com.ikats.scheduler.entity.enumerate.SendStatus;
import com.ikats.scheduler.repository.ICancelOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Logic
 * 
 * 管易取消订单
 * 
 * 自动生成
 *
 * @author over3
 *
 * @version
 *       1.0, 2017-12-18 09:53:44
 */
@Component
public class CancelOrderLogic extends AbstractLogic
{

    @Autowired
    private ICancelOrderRepository repository;
    
    /** 添加单条记录 */
    public void insert(CancelOrderBean bean)
    {
    		int count = repository.insert(bean);
    		if(count <= 0)
    		{
    		this.setSuccess(false);
    		this.setMessage("没有新增");
    		return;
    		}
    		this.setSuccess(true);
    	}

    /** 添加一批记录 */
    public void insertList(List<CancelOrderBean> list)
    {
		//判断订单是否存在
		for (Iterator iter = list.iterator(); iter.hasNext(); )
		{
			CancelOrderBean bean = (CancelOrderBean) iter.next();
			List<CancelOrderBean> holdBean = this.repository.selectByCode(bean.getOrderNo());
			//订单已存在 - 只处理该单号数据已经存在的情况
			if(null != holdBean && holdBean.size() != 0)
			{
				iter.remove();
				if(!holdBean.get(0).getState().equals(SendStatus.SEND_OK.getValue()) && !bean.getOmsRequest().equals(holdBean.get(0).getOmsRequest()))
				{
					//发送报文已修改,且历史订单尚未处理的,进行更新
					this.repository.updateByOrderNo(bean);
				}
			}
		}
		if(list.size() == 0)
		{
			this.setSuccess(false);
			this.setMessage("---------GY取消订单---------未有新的数据录入");
			return;
		}
		int count = repository.insertList(list);
		if (count <= 0)
		{
			this.setSuccess(false);
			this.setMessage("没有新增");

			return;
		}
		this.setSuccess(true);
    }

    /** 更新记录 */
    public void update(CancelOrderBean bean)
    {
    		int count = repository.update(bean);
    		if(count <= 0)
    		{
    		this.setSuccess(false);
    		this.setMessage("修改失败");

    		return;
    		}
    		this.setSuccess(true);
    }

    /** 删除记录 */
    public void delete(Long id)
    {
    		int count = repository.delete(id);
    		if(count <= 0)
    		{
    		this.setSuccess(false);
    		this.setMessage("删除失败");
    		return;
    		}
    		this.setSuccess(true);
    }

    /** 得到一条记录 */
    public CancelOrderBean selectByKey(Long id)
    {
    		CancelOrderBean bean = repository.selectByKey(id);
    		if(bean == null)
    		{
    			this.setSuccess(false);
    			this.setMessage("没有找到");
    			return null;
    		}
    		return bean;
    }

    /** 所有记录计数 */
    public Long selectCount(Map<String,String> express)
    {
    		Long count = repository.selectCount(express);
    		this.setSuccess(true);
    		return count;
    }

    /** 得到查询记录 */
    public List<CancelOrderBean> selectByQuery(Map<String,String> express)
    {
    		List<CancelOrderBean> beanList = repository.selectByQuery(express);
    		if(beanList.size() == 0)
    		{
    			this.setSuccess(false);
    			this.setMessage("没有找到");
    			return null;
    		}
    		this.setSuccess(true);
    		return beanList;
    }

    /** 得到翻页查询记录 */
    public List<CancelOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express)
    {
    		List<CancelOrderBean> beanList = repository.pageByQuery(pageNum, pageSize, express);
    		if(beanList.size() == 0)
    		{
    			this.setSuccess(false);
    			this.setMessage("没有找到");
    			return null;
    		}
    		this.setSuccess(true);
    		return beanList;
    }

    public List<CancelOrderBean> getOrderSendJob()
	{
		List<CancelOrderBean> beanList = this.repository.getOrderSendJob();
		if (beanList.size() == 0) {
			this.setSuccess(false);
			this.setMessage("没有要发送的出库单任务!");
			return null;
		}
		this.setSuccess(true);
		return beanList;
	}
}
