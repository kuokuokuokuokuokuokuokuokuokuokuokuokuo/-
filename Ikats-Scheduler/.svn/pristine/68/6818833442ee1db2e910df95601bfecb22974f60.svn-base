package com.ikats.scheduler.service;

import com.ikats.scheduler.entity.bean.SchedulerBean;

import java.util.List;
import java.util.Map;

/**
 * @Author : liu kuo
 * @Date : 2017/11/17 17:07.
 * @Description : Indulge in study , wasting away
 */
public interface ISchedulerService
{
    Map addJob(SchedulerBean bean);

    Map updateJob(SchedulerBean bean);

    boolean pauseJob(SchedulerBean bean);

    boolean resumeJob(SchedulerBean bean);

    List<SchedulerBean> jobs();

    boolean deleteJob(SchedulerBean bean);

    boolean startAll();

    boolean shutdownAll();
}
