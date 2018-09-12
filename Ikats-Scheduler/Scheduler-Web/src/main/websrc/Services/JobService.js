import api from '../Common/WebAPI';

export default class JobService
{
    static addJob(data)
    {
        let result = api("/scheduler/new.action",data);
        return result;
    }
    static updateJob(data)
    {
        let result = api("/scheduler/update.action",data);
        return result;
    }
    static pauseJob(data)
    {
        let result = api("/scheduler/pause.action",data);
        return result;
    }
    static resumeJob(data)
    {
        let result = api("/Scheduler-Web/scheduler/resume.action",data);
        return result;
    }
    static deleteJob(data)
    {
        let result = api("/Scheduler-Web/scheduler/delete.action",data);
        return result;
    }
    static jobList()
    {
        let result = api("/Scheduler-Web/scheduler/jobs.action",{});
        return result;
    }
    static startAll(data)
    {
        let result = api("/Scheduler-Web/scheduler/startAll.action",data);
        return result;
    }
    static shutDownAll(data)
    {
        let result = api("/Scheduler-Web/scheduler/shutdownAll.action",data);
        return result;
    }
    static selectRecord(data)
    {
        let result = api("/Scheduler-Web/GYEntrance/Debug.action",data);
        return result;
    }
}