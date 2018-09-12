import { observable, action } from "mobx";
import {notification} from 'antd';
import JstEntranceService from "../Services/JstEntranceService";


export default class JstEntranceStore {
    @observable loading;
    @observable gyResult;

    constructor() {
        this.loading = false;
        this.gyResult = "";
    }
    @action
    async sendToJST(data){
        // let data = {appkey:'112194',sessionkey:'50b24306aacf479a9a5651f0fc7cabc3',method:'gy.erp.trade.deliverys.get',page_no:1,page_size:10};
        let result = await JstEntranceService.sendToJST(data);
        this.gyResult = JSON.stringify(result);
    }
}