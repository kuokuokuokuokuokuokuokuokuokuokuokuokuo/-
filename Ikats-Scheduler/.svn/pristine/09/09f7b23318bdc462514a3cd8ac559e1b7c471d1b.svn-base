import { observable, action } from "mobx";
import {notification} from 'antd';
import JobService from "../Services/JobService";


export default class JobListStore {
    @observable loading;
    @observable JobDataTable;
    @observable totalCount;
    @observable record;

    constructor() {
        this.loading = false;
        this.JobDataTable = [];
        this.record = [];
        this.totalCount = 0;
    }

    @action
    async selectJobs()
    {
        this.loading = true;
        let result = await JobService.jobList();
        this.JobDataTable = result;
        //this.totalCount = result.page.totalCount;
        this.loading = false;
    }

    @action
    async addJob(values)
    {
        this.loading = true;
        let data = {...values};
        let result = await JobService.addJob(data);
        this.loading = false;
        if(result.Success)
        {
            notification.open
            ({
                message: '任务添加成功',
                description: result.Message
            });
            let searchResult = await JobService.jobList();
            this.JobDataTable = searchResult;
        }
        else
        {
            notification.open
            ({
                message: '任务添加失败',
                description: result.Message
            });
        }
    }

    @action
    async pauseAllJob()
    {
        this.loading = true;
        let result = await JobService.shutDownAll();
        this.JobDataTable = result;
        //this.totalCount = result.page.totalCount;
        this.loading = false;
        if(result)
        {
            notification.open
            ({
                message: '全部任务暂停成功',
                description: ''
            });
            let result = await JobService.jobList();
            this.JobDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '全部任务暂停失败',
                description: ''
            });
        }
    }
    @action
    async resumeAllJob()
    {
        this.loading = true;
        let result = await JobService.startAll();
        this.JobDataTable = result;
        //this.totalCount = result.page.totalCount;
        this.loading = false;
        if(result)
        {
            notification.open
            ({
                message: '全部任务恢复成功',
                description: ''
            });
            let result = await JobService.jobList();
            this.JobDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '全部任务恢复失败',
                description: ''
            });
        }
    }
    @action
    async deleteJob(jobName,jobGroup)
    {
        this.loading = true;
        let sendData={jobName:jobName,jobGroup:jobGroup};
        let result = await JobService.deleteJob(sendData);
        this.loading = false;
        if(result)
        {
            notification.open
            ({
                message: '任务删除成功',
                description: ''
            });
            let result = await JobService.jobList();
            this.JobDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '任务删除失败',
                description: ''
            });
        }
    }
    @action
    async editJob(triggerName,triggerGroup,cron)
    {
        this.loading = true;
        let sendData={triggerName:triggerName,triggerGroup:triggerGroup,cron:cron};
        let result = await JobService.updateJob(sendData);
        this.loading = false;
        if(result)
        {
            notification.open
            ({
                message: '任务修改成功',
                description: ''
            });
            let result = await JobService.jobList();
            this.JobDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '任务修改失败',
                description: result.message
            });
        }
    }
    @action
    async pauseJob(jobName,jobGroup)
    {
        this.loading = true;
        let sendData={jobName:jobName,jobGroup:jobGroup};
        let result = await JobService.pauseJob(sendData);
        this.loading = false;
        console.info(result);
        if(result)
        {
            notification.open
            ({
                message: '该任务已暂停',
                description: ''
            });
            let result = await JobService.jobList();
            this.JobDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '任务暂停失败!',
                description: ''
            });
        }
    }
    @action
    async resumeJob(jobName,jobGroup)
    {
        this.loading = true;
        let sendData={jobName:jobName,jobGroup:jobGroup};
        let result = await JobService.resumeJob(sendData);
        this.loading = false;
        if(result)
        {
            notification.open
            ({
                message: '该任务已恢复启动',
                description: ''
            });
            let result = await JobService.jobList();
            this.JobDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '恢复启动失败',
                description: ''
            });
        }
    }
    @action
    async selectDmsRecord(){
        let data = {appkey:'112194',sessionkey:'50b24306aacf479a9a5651f0fc7cabc3',method:'gy.erp.trade.deliverys.get',page_no:1,page_size:10};
        let result = await JobService.selectRecord(data);
        console.info(result);
    }
}