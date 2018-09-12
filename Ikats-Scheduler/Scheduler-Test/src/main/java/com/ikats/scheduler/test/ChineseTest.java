package com.ikats.scheduler.test;

import com.ikats.scheduler.email.Email;
import com.ikats.scheduler.email.EmailAuthenticator;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Author : liu kuo
 * @Date : 2018/5/22 13:32.
 * @Description : Indulge in study , wasting away
 */
public class ChineseTest
{
    public static void main(String[] args) throws Exception
    {
        /*String str = "<ServiceResult>\n" +
                "<ResultCode>-201</ResultCode>\n" +
                "<ResultContent>服务失败[该客户(面单类型:普通)面单不足,请联系合作的韵达网点解决此问题]</ResultContent>\n" +
                "</ServiceResult>";
        String testStr = "面单不足";
        System.out.println(str.indexOf(testStr));
        System.out.println(new String(str.getBytes(),"utf-8").indexOf(new String(testStr.getBytes(),"utf-8")));

        String zjz = "<ServiceResult>赵建振<ServiceResult>";
        String z = "建";

        System.out.println(zjz.indexOf(z));*/

       /* String content =
                "尊敬的客户：\n" +
                "        您好！\n" +
                "        感谢使用知行思远信息技术有限公司WMS仓储管理系统。\n" +
                "        系统监控到韵达面单不足，请联系合作的韵达网点解决此问题。\n" +
                "\n" +
                "        此邮件无需回复，如有其他疑问可及时与知行技术工程师联系，谢谢！\n" +
                "\n" +
                "知行思远信息技术有限公司（技术支持）";
        sendTextMail("liukuo@ikats.com","韵达面单不足","尊敬的客户：\n" +
                "        您好！\n" +
                "        感谢使用知行思远信息技术有限公司WMS仓储管理系统。\n" +
                "        系统监控到韵达面单不足，请联系合作的韵达网点解决此问题。\n" +
                "\n" +
                "        此邮件无需回复，如有其他疑问可及时与知行技术工程师联系，谢谢！\n" +
                "\n" +
                "知行思远信息技术有限公司（技术支持）");*/

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(new Date()));
    }

    private static boolean sendTextMail(String a,String b,String c)
    {
        Properties prop = new Properties();
        prop.put("mail.smtp.host","smtp.ym.163.com");
        prop.put("mail.smtp.port","25");
        prop.put("mail.smtp.auth", "true");

        Session sendMailSession = Session.getDefaultInstance(prop,new EmailAuthenticator("chigoose@ikats.com","sinoair2017"));

        try
        {
            Message mailMessage = new MimeMessage(sendMailSession);
            Address from = new InternetAddress("chigoose@ikats.com");
            mailMessage.setFrom(from);

            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(a);
            mailMessage.setRecipient(Message.RecipientType.TO,to);

            mailMessage.setSubject(b);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容

            mailMessage.setText(c);

            // 发送邮件
            Transport.send(mailMessage);
            return true;
        }
        catch (MessagingException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
