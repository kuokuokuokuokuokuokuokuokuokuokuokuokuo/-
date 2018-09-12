import React,{Component} from 'react';
import {Spin,Form,Icon,Input,Checkbox,Button,Row,Col,Select} from 'antd';
import {Link} from 'react-router-dom';
import Style from './SearchStyle';
const FormItem = Form.Item;
const Option = Select.Option;

export class EditComponent extends Component
{
    constructor(props){
        super(props);
        props.postForm(props.form);
    }
    search=()=>{
        this.props.Search();
    }
    render()
    {
        const formItemLayout={
            labelCol: {
                xs: { span: 24 },
                sm: { span: 8 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 14 },
            },
        };
        const {style}=Style;
        const { getFieldDecorator } = this.props.form;
        return (
            <div>

                <Form>
                    <Row>
                        <Col span="24">
                            <FormItem {...formItemLayout}  label="订单号" >
                                {getFieldDecorator('OrderNo', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                })(<Input />)}
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="24">
                            <FormItem {...formItemLayout}  label="发送报文" >
                                {getFieldDecorator('OrderNo', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                })(<Input />)}
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="24">
                            <FormItem {...formItemLayout}  label="返回报文" >
                                {getFieldDecorator('OrderNo', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                })(<Input />)}
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="24">
                            <FormItem {...formItemLayout}  label="发送时间" >
                                {getFieldDecorator('OrderNo', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                })(<Input />)}
                            </FormItem>
                        </Col>
                    </Row>
                </Form>
            </div>
        )
    }
}

const EditForm=Form.create()(EditComponent);
export default EditForm;