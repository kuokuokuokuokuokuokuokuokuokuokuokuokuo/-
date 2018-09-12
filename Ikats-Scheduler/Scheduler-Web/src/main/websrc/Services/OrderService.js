import api from '../Common/WebAPI';

export default class OrderService
{
    static restartOrder(data)
    {
        let result = api("/Scheduler-Web/scheduler/update.action",data);
        return result;
    }
    static selectOrder(data)
    {
        let result = api("/Scheduler-Web/scheduler/update.action",data);
        return result;
    }
}