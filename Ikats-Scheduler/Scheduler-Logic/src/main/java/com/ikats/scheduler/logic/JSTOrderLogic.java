package com.ikats.scheduler.logic;

import com.ikats.scheduler.entity.bean.JSTOrderBean;
import com.ikats.scheduler.entity.enumerate.SendStatus;
import com.ikats.scheduler.repository.IJSTOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Logic
 * <p>
 * 聚水潭订单对接表
 * <p>
 * 自动生成
 *
 * @author over3
 * @version 1.0, 2017-12-05 09:31:12
 */
@Component
@Transactional
public class JSTOrderLogic extends AbstractLogic {

    @Autowired
    private IJSTOrderRepository repository;

    /**
     * 添加单条记录
     */
    public void insert(JSTOrderBean bean) {
        int count = repository.insert(bean);
        if (count <= 0) {
            this.setSuccess(false);
            this.setMessage("没有新增");

            return;
        }
        this.setSuccess(true);
    }

    /**
     * 添加一批记录
     */
    public void insertList(List<JSTOrderBean> list)
    {
        //判断订单是否存在
        for (Iterator iter = list.iterator(); iter.hasNext(); )
        {
            JSTOrderBean bean = (JSTOrderBean) iter.next();
            List<JSTOrderBean> holdBean = this.repository.selectByNo(bean.getOrderNo());
            //订单已存在
            if(null != holdBean && holdBean.size() != 0)
            {
                iter.remove();
//                if(holdBean.get(0).getState().equals(SendStatus.INIT.getValue()) && bean.getOmsRequest().equals(holdBean.get(0).getOmsRequest()))
//                {
//                    //发送报文已修改,且历史订单尚未处理的,进行更新
//                    this.repository.updateByOrderNo(bean);
//                }
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
            this.setMessage("-----JST订单-----未有新的数据录入");
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

    /**
     * 更新记录
     */
    public void update(JSTOrderBean bean) {
        int count = repository.update(bean);
        if (count <= 0) {
            this.setSuccess(false);
            this.setMessage("修改失败");

            return;
        }
        this.setSuccess(true);
    }

    /**
     * 删除记录
     */
    public void delete(Long id) {
        int count = repository.delete(id);
        if (count <= 0) {
            this.setSuccess(false);
            this.setMessage("删除失败");
            return;
        }
        this.setSuccess(true);
    }

    /**
     * 得到一条记录
     */
    public JSTOrderBean selectByKey(Long id) {
        JSTOrderBean bean = repository.selectByKey(id);
        if (bean == null) {
            this.setSuccess(false);
            this.setMessage("没有找到");
            return null;
        }
        return bean;
    }

    /**
     * 所有记录计数
     */
    public Long selectCount(Map<String, String> express) {
        Long count = repository.selectCount(express);
        this.setSuccess(true);
        return count;
    }

    /**
     * 得到查询记录
     */
    public List<JSTOrderBean> selectByQuery(Map<String, String> express) {
        List<JSTOrderBean> beanList = repository.selectByQuery(express);
        if (beanList.size() == 0) {
            this.setSuccess(false);
            this.setMessage("没有找到");
            return null;
        }
        this.setSuccess(true);
        return beanList;
    }

    /**
     * 得到翻页查询记录
     */
    public List<JSTOrderBean> pageByQuery(int pageNum, int pageSize, Map<String, String> express) {
        List<JSTOrderBean> beanList = repository.pageByQuery(pageNum, pageSize, express);
        if (beanList.size() == 0) {
            this.setSuccess(false);
            this.setMessage("没有找到");
            return null;
        }
        this.setSuccess(true);
        return beanList;
    }

    public List<JSTOrderBean> getOrderSendJob()
    {
        List<JSTOrderBean> beanList = this.repository.getOrderSendJob();
        if (beanList.size() == 0) {
            this.setSuccess(false);
            this.setMessage("没有要发送的出库单任务!");
            return null;
        }
        this.setSuccess(true);
        return beanList;
    }
}
