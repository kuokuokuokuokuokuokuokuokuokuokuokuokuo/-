import React, {Component} from 'react';
import { observer } from "mobx-react";
import {Row,Col,Form,Input,Select,Icon,Button,Modal} from 'antd';
const FormItem = Form.Item;
const Option = Select.Option;
const confirm = Modal.confirm;
import Css from "./OrderStyle";
import $ from '../Common/jquery-3.2.1.min';


@observer
class ProductComponent extends Component
{
    constructor(props){
        super(props);
        props.postForm(props.form);
    }
    pauseAll=()=>{
        confirm
        ({
            title: '确定要暂停所有任务吗？',
            onOk:()=>{
                this.props.store.pauseAllOrder();
            },
            onCancel(){}
        })
    };
    restartAll=()=>{
        confirm
        ({
            title: '确定要恢复所有任务吗？',
            onOk:()=>{
                this.props.store.resumeAllOrder();
            },
            onCancel(){}
        })
    };
    search=()=>{
        // var orderNo = $("#search_order";
        // let status = this.listForm.getFieldsValue("status");
        // this.props.store.selectOrder(orderNo,status);

    };
    render(){
        let {style}=Css;
        const {getFieldDecorator}=this.props.form;
        let formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 8 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 14 },
            },
        };
        return(
            <div style={style.ListSearchTable}>
                <Form style={{paddingTop:10,borderTop:"1px solid #ccc"}}>
                    <Row>
                        <Col span="6">
                            <FormItem {...formItemLayout}  label="订单号" >
                                {getFieldDecorator('orderNo', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                })(<Input id="search_order" />)}
                            </FormItem>
                        </Col>
                        <Col span="6">
                            <FormItem {...formItemLayout}  label="任务状态" >
                                {getFieldDecorator('status', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                    initialValue:""
                                })(<Select id="search_select">
                                    <Option value="">请选择</Option>
                                    <Option value="ALL">全部异常订单</Option>
                                    <Option value="SD">面单不足订单</Option>
                                </Select>)}
                            </FormItem>
                        </Col>
                        <Col span="3" className="right">
                            <Button type="primary" style={style.ListAddBtn} onClick={()=>{this.search()}} >搜索</Button>
                        </Col>
                        <Col span="6">
                            <Button style={style.ListAddBtn} onClick={()=>{this.restartAll()}}><Icon type="play-circle-o" />重启所有</Button>
                        </Col>
                    </Row>
                    <Row style={{margin:"0 10px"}}>
                        <Col span="1">
                        </Col>
                    </Row>
                </Form>
            </div>
        )
    }
}
const OrderListForm=Form.create()(ProductComponent);
export default OrderListForm;