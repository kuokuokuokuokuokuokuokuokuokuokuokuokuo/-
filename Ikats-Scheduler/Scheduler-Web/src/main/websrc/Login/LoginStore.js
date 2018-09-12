import { observable, action } from "mobx";
import {notification} from 'antd';
import LoginService from "../Services/LoginService";

export default class LoginStore
{
    @observable loading;
    @observable permissionsDataTable;

    constructor()
    {
        this.loading = false;
        this.permissionsDataTable = []
    }
    @action
    async login(values)
    {
        let data={...values};
        this.loading=true;
        let result=await LoginService.conLogin(data);
        this.loading=false;
        if(result==true)
        {
            window.location.hash='Job';
        }
        else
        {
            notification.open({
                message: '登录失败',
                description: result.message
            });
        }
    }
}