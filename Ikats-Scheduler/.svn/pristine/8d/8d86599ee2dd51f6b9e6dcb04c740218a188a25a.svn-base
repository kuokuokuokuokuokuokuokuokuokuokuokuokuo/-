import React,{Component} from 'react';
import {Spin,Form,Icon,Input,Checkbox,Button,Row,Col,Select} from 'antd';
import {Link} from 'react-router-dom';
import Style from './SearchStyle';
const FormItem = Form.Item;
const Option = Select.Option;

export class SearchComponent extends Component
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
            <div   style={style.ListSearchTable}>
                <Row style={{margin:"0 10px"}}>

                    <Col offset={22} span={2} >
                        <Button type="primary"  style={style.ListAddBtn} onClick={()=>{this.search()}} >搜索</Button>
                    </Col>
                </Row>
                <Form
                    // onSubmit={this.handleSubmit.bind(this)}
                    style={{paddingTop:10,borderTop:"1px solid #ccc"}}
                >
                    <Row>
                        <Col span="6">
                            <FormItem {...formItemLayout}  label="订单号" >
                                {getFieldDecorator('OrderNo', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                })(<Input />)}
                            </FormItem>
                        </Col>
                        <Col span="6">
                            <FormItem {...formItemLayout}  label="状态" >
                                {getFieldDecorator('state', {
                                    rules: [{ message: '搜索条件不能为空格！',whitespace:true}],
                                    initialValue:""
                                })(<Select>
                                    <Option value="">请选择</Option>
                                    <Option value="0">全部异常订单</Option>
                                    <Option value="1">面单不足订单</Option>
                                </Select>)}
                            </FormItem>
                        </Col>
                    </Row>

                </Form>
            </div>
        )
    }
}

const SearchForm=Form.create()(SearchComponent);
export default SearchForm;