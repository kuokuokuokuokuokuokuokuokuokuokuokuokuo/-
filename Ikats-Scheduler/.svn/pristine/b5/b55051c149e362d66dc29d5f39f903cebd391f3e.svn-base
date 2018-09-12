package com.ikats.scheduler.entity.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : liu kuo
 * @Date : 2017/11/6 14:24.
 * @Description : Indulge in study , wasting away
 */
public class SchedulerBean implements Serializable
{
    private static final long serialVersionUID = 2946672521731611567L;

    private String scheduler;
    private String jobName;
    private String jobGroup;
    private String jobDesp;
    //是否持久
    private boolean isDurable = true;
    private String className;
    private String filePath;
    private String triggerName;
    private String triggerGroup;
    //是否立即开始
    private boolean startNow = true;
    private Date startTime;
    //结束时间,没有为永久有效
    private Date endTime;
    private String cron;
    private String state;
    private boolean jar = false;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isJar() {
        return jar;
    }

    public void setJar(boolean jar) {
        this.jar = jar;
    }

    public String getJobDesp() {
        return jobDesp;
    }

    public void setJobDesp(String jobDesp) {
        this.jobDesp = jobDesp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getScheduler() {
        return scheduler;
    }

    public void setScheduler(String scheduler) {
        this.scheduler = scheduler;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public boolean isDurable() {
        return isDurable;
    }

    public void setDurable(boolean durable) {
        isDurable = durable;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public boolean isStartNow() {
        return startNow;
    }

    public void setStartNow(boolean startNow) {
        this.startNow = startNow;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
