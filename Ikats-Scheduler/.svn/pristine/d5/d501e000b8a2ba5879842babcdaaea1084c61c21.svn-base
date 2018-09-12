import { observable, action } from "mobx";
import {notification} from 'antd';
import OrderService from "../Services/OrderService";


export default class OrderListStore {
    @observable loading;
    @observable OrderDataTable;
    @observable totalCount;
    @observable record;

    constructor() {
        this.loading = false;
        this.OrderDataTable = [];
        this.record = [];
        this.totalCount = 0;
    }

    @action
    async selectOrder(orderNo,state)
    {
        this.loading = true;
        let sendData={orderNo:orderNo,state:state};
        let result = await OrderService.selectOrder(sendData);
        this.OrderDataTable = result;
        //this.totalCount = result.page.totalCount;
        this.loading = false;
    }


    @action
    async restartOrder(orderNo)
    {
        this.loading = true;
        let sendData={orderNo:orderNo};
        let result = await OrderService.restartOrder(sendData);
        this.OrderDataTable = result;
        this.loading = false;
        if(result)
        {
            notification.open
            ({
                message: '任务重启成功,请稍后查看结果',
                description: ''
            });
            let result = await OrderService.OrderList();
            this.OrderDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '任务重启失败,请稍后再试',
                description: ''
            });
        }
    }
    @action
    async restartAllOrder()
    {
        this.loading = true;
        let result = await OrderService.restartOrder();
        this.OrderDataTable = result;

        this.loading = false;
        if(result)
        {
            notification.open
            ({
                message: '全部订单重启成功,请稍后查看结果',
                description: ''
            });
            let result = await OrderService.OrderList();
            this.OrderDataTable = result;
        }
        else
        {
            notification.open
            ({
                message: '全部订单重启失败',
                description: ''
            });
        }
    }
}