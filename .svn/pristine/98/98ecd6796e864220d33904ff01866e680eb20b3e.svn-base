/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ctl.smartsignage.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/**
 * @author Arun Kumar Tiwari
 */

public class MultipleEmailSendWithAttachement {

    public static String sendMultipleEmailWithAttachement(String destinationAddress, String ccAddress, String subject, String msg, String file, String fileName) throws Exception {

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
            message.setFrom(new InternetAddress("","info@kenniscentrumhoreca.nl"));
            message.setSubject(subject);

            // who will get the email (To:)
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationAddress, false));
            // who will get the email as (carbon copy)
            //message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress, false));

             // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // adding the message
            messageBodyPart.setText(msg);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();
            // Setting text message part
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

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
