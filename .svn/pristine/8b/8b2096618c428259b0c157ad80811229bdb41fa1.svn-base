package com.ctl.smartsignage.util;

import javax.mail.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Arun Kumar Tiwari
 */
class Auth extends Authenticator {

    //private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_AUTH_USER = "41224";
    private static final String SMTP_AUTH_PWD = "22341";

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }

}
