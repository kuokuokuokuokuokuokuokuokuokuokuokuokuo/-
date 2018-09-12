import { observable, action } from "mobx";
import {notification} from 'antd';
import EntranceService from "../Services/EntranceService";


export default class EntranceStore {
    @observable loading;
    @observable gyResult;

    constructor() {
        this.loading = false;
        this.gyResult = "";
    }
    @action
    async sendToGuanYi(data){
        // let data = {appkey:'112194',sessionkey:'50b24306aacf479a9a5651f0fc7cabc3',method:'gy.erp.trade.deliverys.get',page_no:1,page_size:10};
        let result = await EntranceService.sendToGuanYi(data);
        this.gyResult = JSON.stringify(result);
    }
}