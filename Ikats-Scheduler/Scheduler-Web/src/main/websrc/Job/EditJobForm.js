import React, {Component} from 'react';
import { observer } from "mobx-react";
import {Row,Col,Form,Input,DatePicker,Switch} from 'antd';
const FormItem = Form.Item;

@observer
class EditJobComponent extends Component {
    constructor(props){
        super(props);
        props.postForm(props.form);
        this.state = {
            confirmDirty: false
        };
    }
    render(){
        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span:11 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 9 },
            },
        };
        const { getFieldDecorator } = this.props.form;
        return(
            <Form>
                <FormItem {...formItemLayout} label="旧的Cron表达式">
                    <span>{this.props.cron}</span>
                </FormItem>
                <FormItem {...formItemLayout} label="Cron表达式">
                    {getFieldDecorator('cron', {
                        rules: [{required: true, message: '不会就百度'}],
                    })(
                        <Input type="text"/>
                    )}
                </FormItem>
                <Row style={{margin:15}}>
                    <Col span="24">
                        <span style={{color: "red"}}>*注：现在只允许修改 Cron ，更多需求请删掉老的并重建。</span>
                    </Col>
                </Row>
            </Form>
        )
    }
}
const EditJobForm = Form.create()(EditJobComponent);

export default EditJobForm;
