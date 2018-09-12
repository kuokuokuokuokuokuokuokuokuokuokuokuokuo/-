package com.ikats.scheduler.service;

import com.ikats.scheduler.entity.bean.SchedulerBean;
import com.ikats.scheduler.util.GetClassFromJar;
import com.ikats.scheduler.util.JedisUtil;
import com.ikats.wharf.config.annotation.Service;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : liu kuo
 * @Date : 2017/11/17 17:12.
 * @Description : Indulge in study , wasting away
 */
@Service
public class SchedulerService implements ISchedulerService
{

    private static String JOB_NAME = "LJobName";
    private static String TRIGGRR_NAME = "JGroup";
    private static String JOB_GROUP = "LTriggerName";
    private static String TRIGGRR_GROUP = "TGroup";

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public Map addJob(SchedulerBean bean) {
        Map result = new HashMap();
        Class job = null;
        try {
            if(bean.isJar())
            {
                //外部jar动态加载,把任务加载到系统的类加载去中,重启后需要把任务加到系统内,否则ClassNotFound
                job = GetClassFromJar.loadJar(bean.getFilePath(),bean.getClassName());
            }
            else
            {
                job = Class.forName(bean.getClassName());
            }
            if(null == job)
            {
                result.put("Success",false);
                result.put("Message","未找到该任务!");
                return result;
            }
            Long index = JedisUtil.getIndex();
            Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
            // 任务名，任务组，任务执行类
            JobDetail jobDetail= JobBuilder.newJob(job)
                    .withIdentity(JOB_NAME + index,JOB_GROUP + index)
                    .withDescription(bean.getJobDesp()).storeDurably(true).build();
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(TRIGGRR_NAME + index,TRIGGRR_GROUP + index);
            //是否立即开始
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(bean.getCron()));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown())
            {
                scheduler.start();
            }
        } catch (Exception e)
        {
            result.put("Success",false);
            result.put("Message",e.getMessage());
            return result;
        }
        result.put("Success",true);
        return result;
    }

    @Override
    public Map updateJob(SchedulerBean bean)
    {
        Map result = new HashMap();
        try {
            Scheduler sched = schedulerFactoryBean.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(bean.getTriggerName(),bean.getTriggerGroup());
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
            if (trigger == null)
            {
                result.put("Success",false);
                return result;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(bean.getCron())) {
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(bean.getTriggerName(),bean.getTriggerGroup());
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(bean.getCron()));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                sched.rescheduleJob(triggerKey, trigger);
                /** 方式一 ：调用 rescheduleJob 结束 */

                /** 方式二：先删除，然后在创建一个新的Job  */
                //JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
                //Class<? extends Job> jobClass = jobDetail.getJobClass();
                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron);
                /** 方式二 ：先删除，然后在创建一个新的Job */
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        result.put("Success",true);
        return result;
    }

    @Override
    public boolean pauseJob(SchedulerBean bean) {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        if(StringUtils.isBlank(bean.getJobName())
                || StringUtils.isBlank(bean.getJobGroup()))
        {
            return false;
        }
        JobKey jobKey = JobKey.jobKey(bean.getJobName(),bean.getJobGroup());
        try
        {
            scheduler.pauseJob(jobKey);
        }catch (SchedulerException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean resumeJob(SchedulerBean bean) {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        if(StringUtils.isBlank(bean.getJobName())
                || StringUtils.isBlank(bean.getJobGroup()))
        {
            return false;
        }
        try
        {
            JobKey jobKey = JobKey.jobKey(bean.getJobName(),bean.getJobGroup());
            scheduler.resumeJob(jobKey);
        }catch (SchedulerException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<SchedulerBean> jobs() {
        List<SchedulerBean> result = new ArrayList<SchedulerBean>();
        try
        {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            for (String groupName : scheduler.getJobGroupNames())
            {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName)))
                {
                    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                    String jobName = jobKey.getName();
                    String jobGroup = jobKey.getGroup();
                    //get job's trigger
                    List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    TriggerKey triggerKey = triggers.get(0).getKey();
                    CronTrigger cronTrigger = (CronTrigger) triggers.get(0);
                    String cronExp = cronTrigger.getCronExpression();
                    Trigger.TriggerState state = scheduler.getTriggerState(triggerKey);

                    SchedulerBean bean = new SchedulerBean();
                    bean.setJobName(jobName);
                    bean.setJobGroup(jobGroup);
                    bean.setJobDesp(jobDetail.getDescription());
                    bean.setClassName(jobDetail.getJobClass().toString().replaceFirst("class ",""));
                    bean.setTriggerName(triggerKey.getName());
                    bean.setTriggerGroup(triggerKey.getGroup());
                    bean.setStartTime(cronTrigger.getStartTime());
                    bean.setCron(cronExp);
                    bean.setState(state.toString());
                    result.add(bean);
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteJob(SchedulerBean bean) {
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(bean.getJobName(),bean.getJobGroup());
        try
        {
            scheduler.deleteJob(jobKey);
        }catch (SchedulerException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean startAll() {
        try
        {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            scheduler.start();
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean shutdownAll()
    {
        try
        {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            if (!scheduler.isShutdown())
            {
                scheduler.shutdown();
            }
        }catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
