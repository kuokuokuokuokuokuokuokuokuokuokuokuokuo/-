package com.ikats.scheduler.job;

import com.ikats.scheduler.email.Email;
import com.ikats.scheduler.entity.bean.JSTOrderBean;
import com.ikats.scheduler.entity.enumerate.SendStatus;
import com.ikats.scheduler.entity.exception.DmsOrderSettlementException;
import com.ikats.scheduler.logic.JSTOrderLogic;
import com.ikats.scheduler.util.OmsJSTPostUtil;
import com.ikats.scheduler.util.SystemOutMessage;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author : liu kuo
 * @Date : 2017/10/26 15:14.
 * @Description : Indulge in study , wasting away
 */

public class OmsSendJSTInvoiceJob extends QuartzJobBean
{

    @Autowired
    private JSTOrderLogic logic;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SystemOutMessage.start("聚水潭 TO OMS 任务",sdf.format(new Date()));
        if(null == logic)
        {
            SystemOutMessage.body("false 系统异常");
            return;
        }
        List<JSTOrderBean> updateBeans = new ArrayList<JSTOrderBean>();
        try
        {
            List<JSTOrderBean> orderBeans = this.logic.getOrderSendJob();
            if(null == orderBeans || orderBeans.size() ==0)
            {
                SystemOutMessage.body("没有新的聚水潭订单可发送");
                return;
            }
            for(JSTOrderBean bean : orderBeans)
            {
                JSTOrderBean update = new JSTOrderBean();
                update.setId(bean.getId());
                update.setTimes(bean.getTimes() + 1);
                update.setSendTime(new Date());
                String result = OmsJSTPostUtil.PostXml(bean.getOmsRequest());
                if(result.contains("<ResultCode>1</ResultCode>") || result.contains("<ResultCode>2</ResultCode>"))
                {
                    update.setState(SendStatus.SEND_OK.getValue());
                }
                else
                {
                    update.setState(SendStatus.SEND_ERROR.getValue());
                }
                update.setReturnTime(new Date());
                update.setOmsResponse(result);

                updateBeans.add(update);
            }
        }catch (DmsOrderSettlementException e)
        {
            SystemOutMessage.body(" false  " + e.getMessage());
            Email.sendTextMail("liukuo@ikats.com", "聚水潭发货单发送任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("zhangxiaotao@ikats.com", "聚水潭发货单发送任务", ExceptionUtils.getStackTrace(e));
            Email.sendTextMail("wuqing@ikats.com", "聚水潭发货单发送任务", ExceptionUtils.getStackTrace(e));
        }finally
        {
            for(JSTOrderBean bean : updateBeans)
            {
                this.logic.update(bean);
            }
        }
        SystemOutMessage.end("聚水潭 TO OMS 任务",sdf.format(new Date()));
    }
}
