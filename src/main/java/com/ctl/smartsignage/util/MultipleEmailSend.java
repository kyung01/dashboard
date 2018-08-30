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
public class MultipleEmailSend {

    public static String sendMultipleEmail(String destinationAddress, String ccAddress, String subject, String msg) throws Exception {

//        String destinationAddress = "mr.abhijit.8@gmail.com, bwnayan@gmail.com";
//        String ccAddress = "sridebrajmallick@gmail.com";
//        String subject = "test mail";
//        String msg = "testing me";

        String status = "success";
        // Create a session
        String host = "smtp.gmail.com";
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        // We need TTLS, which gmail requires
        props.put("mail.smtp.starttls.enable", "true");

        // Create a session
        Session session = Session.getDefaultInstance(props, new Auth());

        try {
            // Make a new message
            MimeMessage message = new MimeMessage(session);

            // Who is this message from
            message.setFrom(new InternetAddress("", subject));

            // who will get the email (To:)
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationAddress, false));
            // who will get the email as (carbon copy)
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress, false));

            // Subject and body
            message.setSubject(subject);
            // message.setText(msg);
            message.setContent(msg, "text/html; charset=ISO-8859-1");

            // We can do more here, set the date, the headers, etc.
            Transport.send(message);
            System.out.println("Mail sent!");
        } catch (Exception e) {
            status = "faild";
            throw new UtilityError("unable to send email");

        }
        return status;
    }
}
