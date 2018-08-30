/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ctl.smartsignage.util;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @author Arun Kumar Tiwari
 */
public class  SendEmail {

    public static String sendEmail(String destinationAddress, String subject, String msg,String host,Integer port) throws Exception {
        String status = "success";
        // Create a session
        //String host = "smtp.gmail.com";
        //Integer port = 25;
        Properties props = new Properties();


        //"<H1>Hello</H1>" + "<img src=\"cid:memememe\">";
        // SMTP Session
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        // We need TTLS, which gmail requires
        props.put("mail.smtp.starttls.enable", "true");

        // Create a session
        Session session = Session.getDefaultInstance(props, new Auth());

        try {
            // Make a new message
            MimeMessage message = new MimeMessage(session);

            // Who is this message from
            //message.setFrom(new InternetAddress("", subject));

            // Who is this message to (we could do fancier things like make a list or add CC's)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationAddress, false));
            //message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse("iamatiwari@gmail.com", false));

            // Subject and body
            message.setSubject(subject);
            // message.setText(msg);
            message.setContent(msg, "text/html; charset=ISO-8859-1");


            // We can do more here, set the date, the headers, etc.
            Transport.send(message);
            System.out.println("Mail sent!");
        } catch (Exception e) {
            status = "faild";
            e.printStackTrace();
            throw new UtilityError("unable to send email");


        }
        return status;
    }
}
