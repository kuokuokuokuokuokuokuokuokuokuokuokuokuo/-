import React,{Component} from 'react';
import {Spin,Form,Icon,Input,Checkbox,Button,Row,Col} from 'antd';
import {Link} from 'react-router-dom';
import Style from './LoginStyle';
const FormItem = Form.Item;

export class LoginComponent extends Component
{
    handleSubmit(e)
    {
        e.preventDefault();
        this.props.form.validateFields((err, values) =>
        {
            if (!err)
            {
                this.props.userLogin(values);
            }
        });
    }

    render()
    {
        let {loginform}=Style;
        const { getFieldDecorator } = this.props.form;
        return (
            <Spin spinning={this.props.loading} style={{zIndex:999}}>
                    <Form style={loginform.content} onSubmit={this.handleSubmit.bind(this)}>

                        <FormItem label="用户名">
                            {getFieldDecorator('username', {
                                rules: [{ required: true, message: '请输入正确的账号' }],
                            })(
                            <Input prefix={<Icon type="user" style={loginform.content.iconstyle} />} placeholder="" size="large" />
                            )}
                        </FormItem>
                        <FormItem label="密码">
                            {getFieldDecorator('password', {
                                rules: [{ required: true, message: '请输入正确的密码' }],
                            })(
                            <Input prefix={<Icon type="lock" style={loginform.content.iconstyle}/>} type="password" placeholder="" size="large" />
                            )}
                        </FormItem>

                         <Row  style={{margin:"3% 0",height:'5%'}}>
                             <Checkbox>记住密码</Checkbox>
                         </Row>

                        <FormItem  style={{margin:"3% 0",height:'14%'}}>
                                <Button type="primary" htmlType="submit" className="login-form-button" style={{width:"100%"}} >
                                     登陆
                                </Button>
                        </FormItem>
                        <div  style={{margin:"3% 0",height:'15%'}}>
                            {/*<a href="">忘记密码</a> &nbsp;|&nbsp;*/}
                            还没有账号？<Link to='/Register/Org'> 立即注册</Link>
                        </div>

                    </Form>
            </Spin>
        )
    }
}

const LoginForm=Form.create()(LoginComponent);
export default LoginForm;