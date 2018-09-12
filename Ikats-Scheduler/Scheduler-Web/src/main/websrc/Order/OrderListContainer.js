import React, {Component} from 'react';
import { observer } from "mobx-react";
import {Breadcrumb,Icon,Modal,Pagination,Table,Tooltip } from 'antd';
import OrderListForm from "./OrderListForm";
import Css from "./OrderStyle";
const confirm = Modal.confirm;


@observer
export default class OrderListContainer extends Component
{
    constructor(props){
        super(props);
        this.state={
            editVisible: false,
            cron :'',
            triggerName :'',
            triggerGroup :''
        };
        this.page = {pageNum: 1, pageSize: 10};
        this.data = {};
        props.store.selectOrder();
    }
    changePage(page){
        this.page.pageNum = page;
        this.props.store.selectOrder(this.data,this.page);
    }
    getListForm(form){
        this.listForm = form;
    }
    search(){
        this.listForm.validateFields((err, data) =>
        {
            if(!err){
                this.page = {pageNum: 1, pageSize: 10};
                this.data = data;
                this.props.store.selectOrder();
            }
        })
    }
    delete=(OrderName,OrderGroup)=>{
        confirm
        ({
            title: '确定要删除该任务吗？',
            onOk:()=>{
                this.props.store.deleteOrder(OrderName,OrderGroup);
            },
            onCancel(){}
        })
    };
    pause=(OrderName,OrderGroup)=>{
        confirm
        ({
            title: '确定要暂停该任务吗？',
            onOk:()=>{
                this.props.store.pauseOrder(OrderName,OrderGroup);
            },
            onCancel(){}
        })
    };
    resume=(OrderName,OrderGroup)=>{
        confirm
        ({
            title: '确定要恢复该任务吗？',
            onOk:()=>{
                this.props.store.resumeOrder(OrderName,OrderGroup);
            },
            onCancel(){}
        })
    };
    showModal = (triggerName,triggerGroup,cron) => {
        this.setState({
            editVisible: true,
            cron : cron,
            triggerName : triggerName,
            triggerGroup:triggerName
        });
    };
    handleEditCancel = (e) => {
        this.setState({
            editVisible: false
        });
    };
    render(){
        let {style}=Css;
        let store = this.props.store;
        const columns = [
            {title: '任务名', dataIndex: 'OrderName', key: 'OrderName'},
            {title: '任务组', dataIndex: 'OrderGroup', key: 'OrderGroup'},
            {title: '任务备注', dataIndex: 'OrderDesp', key: 'OrderDesp'},
            {title: '触发器名', dataIndex: 'triggerName', key: 'triggerName'},
            {title: '触发器组', dataIndex: 'triggerGroup', key: 'triggerGroup'},
            {title: '任务类', dataIndex: 'className', key: 'className'},
            {title: '开始时间', dataIndex: 'startTime', key: 'startTime'},
            {title: '结束时间', dataIndex: 'endTime', key: 'endTime'},
            {title: '时间表达式', dataIndex: 'cron', key: 'cron'},
            {title: '任务状态', dataIndex: 'state', key: 'state'},
            {title: '操作', key: 'action', render: (text, item) => (
                <div>
                    <Tooltip placement="top" title="编辑" arrowPointAtCenter>
                        <a onClick={()=>{this.showModal(item.triggerName,item.triggerGroup,item.cron)}}><Icon type="edit" /></a><span className="ant-divider" />
                    </Tooltip>
                    <Tooltip placement="top" title="删除" arrowPointAtCenter>
                        <a onClick={()=>{this.delete(item.OrderName,item.OrderGroup)}}><Icon type="delete" /></a><span className="ant-divider" />
                    </Tooltip>
                    <Tooltip placement="top" title="暂停" arrowPointAtCenter>
                        <a onClick={()=>{this.pause(item.OrderName,item.OrderGroup)}}><Icon type="pause" /></a><span className="ant-divider" />
                    </Tooltip>
                    <Tooltip placement="top" title="启动" arrowPointAtCenter>
                        <a onClick={()=>{this.resume(item.OrderName,item.OrderGroup)}}><Icon type="play-circle-o" /></a>
                    </Tooltip>
                </div>
            )}
        ];
        return(
            <div>
                <Modal
                    title="编辑任务"
                    visible={this.state.editVisible}
                    onOk={this.handleEditOk}
                    onCancel={this.handleEditCancel}
                >
                </Modal>
                <OrderListForm store={this.props.store} searchData={this.data} search={this.search.bind(this)} postForm={this.getListForm.bind(this)}/>
                <Table columns={columns} dataSource={[...store.OrderDataTable]} pagination={false} rowKey={item => item.id} size="middle" className="pd" style={style.FormStyle}/>
                <Pagination style={style.Pagination} current={this.page.pageNum} pageSize={this.page.pageSize} total={store.totalCount} onChange={this.changePage.bind(this)}/>
            </div>
        )
    }
}