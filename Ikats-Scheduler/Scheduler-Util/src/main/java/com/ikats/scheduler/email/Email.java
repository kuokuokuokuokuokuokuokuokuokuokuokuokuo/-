package com.ikats.scheduler.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class Email
{
    private static MailSenderInfo mailSenderInfo;
    static
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-email.xml");
        mailSenderInfo = context.getBean("mailSenderInfo",MailSenderInfo.class);
    }

    public static Boolean sendTextMail(String toAddress,String subject,String content)
    {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", mailSenderInfo.getMailServerHost());
        prop.put("mail.smtp.port", mailSenderInfo.getMailServerPort());
        prop.put("mail.smtp.auth", "true");

        Session sendMailSession = Session.getDefaultInstance(prop,new EmailAuthenticator(mailSenderInfo.getUserName(),mailSenderInfo.getPassword()));

        try
        {
            Message mailMessage = new MimeMessage(sendMailSession);
            Address from = new InternetAddress(mailSenderInfo.getFromAddress());
            mailMessage.setFrom(from);

            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(toAddress);
            mailMessage.setRecipient(Message.RecipientType.TO,to);

            mailMessage.setSubject(subject);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容

            mailMessage.setText(content);

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

    public static Boolean sendHtmlMail(String toAddress,String subject,String content)
    {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", mailSenderInfo.getMailServerHost());
        prop.put("mail.smtp.port", mailSenderInfo.getMailServerPort());
        prop.put("mail.smtp.auth", "true");

        Session sendMailSession = Session.getDefaultInstance(prop, new EmailAuthenticator(mailSenderInfo.getUserName(), mailSenderInfo.getPassword()));
        try
        {
            Message mailMessage = new MimeMessage(sendMailSession);
            Address from = new InternetAddress(mailSenderInfo.getFromAddress());
            mailMessage.setFrom(from);

            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(toAddress);
            mailMessage.setRecipient(Message.RecipientType.TO, to);

            mailMessage.setSubject(subject);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());

            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(content, "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);

            return true;
        }
        catch (MessagingException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
