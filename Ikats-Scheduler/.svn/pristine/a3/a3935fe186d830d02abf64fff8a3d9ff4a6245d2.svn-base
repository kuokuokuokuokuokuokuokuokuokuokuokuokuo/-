import React, {Component} from 'react';
import { observer } from "mobx-react";
import {Row,Col,Form,Input,DatePicker,Switch} from 'antd';
const FormItem = Form.Item;

@observer
class NewJobComponent extends Component {
    constructor(props) {
        super(props);
        props.postForm(props.form);
        this.state = {
            confirmDirty: false,
            pathShow : 'none'
        };
    }
    handleSetCreateTime(date,dateString)
    {
        console.log(this.props.form);
        this.props.form.setFieldsValue({"startTime":dateString});
    }
    handleIsJar(checked)
    {
        if(checked)
        {
            this.setState({
                pathShow : ''
            });
        }
        else
        {
            this.setState({
                pathShow : 'none'
            });
        }
    }
    handleSetEndTime(date, dateString){
        this.state.setFieldsValue({"endTime": dateString});
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
                <FormItem {...formItemLayout} label="任务备注">
                    {getFieldDecorator('jobDesp', {
                        rules: [{required:true ,message: '找不到别问我' }],
                    })(
                        <Input type="text"/>
                    )}
                </FormItem>
                <FormItem {...formItemLayout} label="Cron表达式">
                    {getFieldDecorator('cron', {
                        rules: [{required: true, message: '不会就百度'}],
                    })(
                        <Input type="text"/>
                    )}
                </FormItem>
                <FormItem {...formItemLayout} label="来自  jar">
                    {getFieldDecorator('jar', {
                        rules: [{required: false, message: ''}],
                    })(
                        <Switch onChange={this.handleIsJar.bind(this)} defaultChecked={false} />
                    )}
                </FormItem>
                <FormItem style={{display:this.state.pathShow}} {...formItemLayout} label="文件路径">
                    {getFieldDecorator('filePath', {
                        rules: [{required: false, message: '还是去确认下吧,Copy过来'}],
                    })(
                        <Input type="text"/>
                    )}
                </FormItem>
                <FormItem {...formItemLayout} label="全类名">
                    {getFieldDecorator('className', {
                        rules: [{required: true, message: '还是去确认下吧,Copy过来'}],
                    })(
                        <Input type="text"/>
                    )}
                </FormItem>
                <Row>
                    <Col span="2">
                    </Col>
                    <Col span="10">
                        {getFieldDecorator("startTime")}
                        <DatePicker
                            format="YYYY-MM-DD HH:mm:ss"
                            onChange={this.handleSetCreateTime.bind(this)}
                        />
                    </Col>
                    <Col span="2">
                    </Col>
                    <Col span="10">
                        {getFieldDecorator("endTime")}
                        <DatePicker
                                    format="YYYY-MM-DD HH:mm:ss"
                                    onChange={this.handleSetEndTime.bind(this)}
                        />
                    </Col>
                </Row>
                <Row style={{margin:15}}>
                    <Col span="24">
                        <span style={{color: "red"}}>*注：不选择开始时间，定时任务立即开始；不选择结束时间，定时任务不会主动停止。</span>
                    </Col>
                </Row>
            </Form>
        )
    }
}
const NewJobForm = Form.create()(NewJobComponent);

export default NewJobForm;
