package com.ikats.scheduler.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAuthenticator extends Authenticator
{
    String userName = "";
    String password = "";

    public EmailAuthenticator(String userName,String password)
    {
        this.userName=userName;
        this.password=password;
    }

    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(userName, password);
    }


}
