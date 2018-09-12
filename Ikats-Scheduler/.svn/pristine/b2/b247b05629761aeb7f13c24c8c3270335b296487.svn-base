package com.ikats.scheduler.controller;

import com.ikats.scheduler.entity.bean.SchedulerBean;
import com.ikats.scheduler.service.ISchedulerService;
import com.ikats.wharf.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

/**
 * @Author : liu kuo
 * @Date : 2017/10/31 16:18.
 * @Description : Indulge in study , wasting away
 */
@Controller
@RequestMapping("scheduler")
public class JobController
{

//    @Autowired
//    private SchedulerFactoryBean schedulerFactoryBean;
    @Reference(timeout = 300000)
    private ISchedulerService service;

    private static String JOB_NAME = "LJobName";
    private static String TRIGGRR_NAME = "JGroup";
    private static String JOB_GROUP = "LTriggerName";
    private static String TRIGGRR_GROUP = "TGroup";
    /**
     * 修改单个任务
     */
    @ResponseBody
    @RequestMapping(value = "new",method = {RequestMethod.POST})
    public Map addJob(@RequestBody SchedulerBean schedulerBean)
    {
        return service.addJob(schedulerBean);
        /*Map result = new HashMap();
        Class job = null;
        try {
            if(schedulerBean.isJar())
            {
                //外部jar动态加载,把任务加载到系统的类加载去中,重启后需要把任务加到系统内,否则ClassNotFound
                job = GetClassFromJar.loadJar(schedulerBean.getFilePath(),schedulerBean.getClassName());
            }
            else
            {
                job = Class.forName(schedulerBean.getClassName());
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
                    .withDescription(schedulerBean.getJobDesp()).storeDurably(true).build();
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(TRIGGRR_NAME + index,TRIGGRR_GROUP + index);
            //是否立即开始
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(schedulerBean.getCron()));
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
        return result;*/
    }

    /**
     * 修改单个任务
     */
    @ResponseBody
    @RequestMapping(value = "update",method = {RequestMethod.POST})
    public Map updateJob(@RequestBody SchedulerBean schedulerBean)
    {
        return this.service.updateJob(schedulerBean);
    }

    /**
     * 暂停单个任务
     */
    @ResponseBody
    @RequestMapping(value = "pause",method = {RequestMethod.POST})
    public boolean pauseJob(@RequestBody SchedulerBean schedulerBean)
    {
        return this.service.pauseJob(schedulerBean);
    }

    /**
     * 恢复单个任务
     */
    @ResponseBody
    @RequestMapping(value = "resume",method = {RequestMethod.POST})
    public boolean resumeJob(@RequestBody SchedulerBean schedulerBean)
    {
        return this.service.resumeJob(schedulerBean);
    }

    /**
     * 删除单个job
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = {RequestMethod.POST})
    public boolean deleteJob(@RequestBody SchedulerBean schedulerBean)
    {
        return this.service.deleteJob(schedulerBean);
    }

    /**
     *  得到任务列表
     */
    @ResponseBody
    @RequestMapping(value = "jobs",method = {RequestMethod.POST})
    public List<SchedulerBean> jobLists()
    {
        return this.service.jobs();
    }

    /**
     *  暂停所有任务
     */
    @ResponseBody
    @RequestMapping(value = "startAll",method = {RequestMethod.POST})
    public boolean startJobs()
    {
        return this.service.startAll();
    }

    /**
     *  重启所有任务
     */
    @ResponseBody
    @RequestMapping(value = "shutdownAll",method = {RequestMethod.POST})
    public boolean shutdownJobs()
    {
        return this.service.shutdownAll();
    }
}
