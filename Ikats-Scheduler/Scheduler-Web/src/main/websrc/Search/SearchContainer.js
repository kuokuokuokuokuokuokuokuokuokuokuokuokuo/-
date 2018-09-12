import React, {Component} from 'react';
import { observer } from "mobx-react";
import SearchForm from './SearchForm';
import EditForm from './EditForm';
import {Row,Col,Table,Pagination,Modal,Button} from 'antd';
import Style from "./SearchStyle";

@observer
export default class SearchContainer extends Component
{
    state={
        editVisible:false
    };
    constructor()
    {
        super();
    }
    handleSearch=()=>{
        this.SearchForm.validateFieldsAndScroll((err, values) =>{
            console.log(values,8989000);
        })
    };
    getSearchForm=(form)=>{
        this.SearchForm=form;
    };
    getEditForm=(form)=>{
        this.EditForm=form;
    };
    handleEditOk=()=>{
        this.EditForm.validateFieldsAndScroll((err,values)=>{
            console.log(values,7878)
        })
    };
    handleEditCancel=()=>{

    };
    handleShowModal=()=>{
        this.setState({editVisible:true})
    };
    handleHideModal=()=>{
        this.setState({editVisible:false})
    };
    render()
    {
        const {style}=Style;
        const columns = [
                {title: '订单号', dataIndex: 'order', key: 'order'},
                {title: '发送报文', dataIndex: 'jobGroup', key: 'jobGroup'},
                {title: '返回报文', dataIndex: 'state', key: 'state'},
                {title: '发送时间', dataIndex: 'time', key: 'time'},
                {title: '操作', key: 'action', render: (text, item) => (
                    <div>
                        <Tooltip placement="top" title="编辑" arrowPointAtCenter>
                            <a onClick={()=>{this.handleShowModal()}}><Icon type="edit" /></a><span className="ant-divider" />
                        </Tooltip>
                        <Tooltip placement="top" title="发送" arrowPointAtCenter>
                            <a><Icon type="delete" /></a><span className="ant-divider" />
                        </Tooltip>

                    </div>
                )}
        ]

        return (
            <div>
                <Modal
                    title="编辑"
                    visible={this.state.editVisible}
                    onOk={this.handleEditOk}
                    onCancel={this.handleHideModal}
                >
                <EditForm
                    postForm = {this.getEditForm.bind(this)}

                />
                </Modal>
                <Button onClick={this.handleShowModal}>aaa</Button>
                <SearchForm
                    postForm={this.getSearchForm}
                    Search={this.handleSearch}
                />
                <Table columns={columns}  rowKey={item => item.order} size="middle" className="pd" />
                <Pagination
                    style={style.Pagination}
                    // current={this.page.pageNum}
                    // pageSize={this.page.pageSize}
                    // total={store.totalCount}
                    // onChange={this.changePage.bind(this)}
                />
            </div>
        )
    }
}
