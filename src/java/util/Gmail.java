/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Used to send emails. Specifically for Candidate users, they'll receive an
 * email when they've been selected for interview.
 *
 * @author 839645
 * @version 1.0
 */
public class Gmail {

    /**
     * Prepares mail to be sent.
     *
     * @param to recipient of the mail
     * @param subject subject of the mail
     * @param template template of the mail
     * @param tags tags associated with the mail
     * @throws Exception thrown if something goes wrong
     */
    public static void sendMail(String to, String subject, String template, HashMap<String, String> tags) throws Exception {

        String body = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(template)));

            String line = br.readLine();
            while (line != null) {
                body += line;
                line = br.readLine();
            }

            for (String key : tags.keySet()) {
                body = body.replace("{{" + key + "}}", tags.get(key));
            }

        } catch (Exception e) {
            Logger.getLogger(Gmail.class.getName()).log(Level.SEVERE, null, e);
        }
        sendMail(to, subject, body, true);
    }

    /**
     * Used to send the actual mail after its been prepared.
     *
     * @param to recipient of the mail
     * @param subject subject of the mail
     * @param body body of the mail
     * @param bodyIsHTML determines if body is HTML
     * @throws NamingException thrown if naming is incorrect
     * @throws AddressException thrown if address is incorrect
     * @throws MessagingException thrown if there is error during the messaging
     */
    public static void sendMail(String to, String subject, String body, boolean bodyIsHTML) throws NamingException, AddressException, MessagingException {

        Context env = (Context) new InitialContext().lookup("java:comp/env");
        String username = (String) env.lookup("webmail-username");
        String password = (String) env.lookup("webmail-password");
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session curSess = Session.getDefaultInstance(props);

        Message msg = new MimeMessage(curSess);
        // address
        Address fromAddress = new InternetAddress(username);
        Address toAddress = new InternetAddress(to);
        msg.setFrom(fromAddress);
        msg.setRecipient(Message.RecipientType.TO, toAddress);
        msg.setSubject(subject);
        if (bodyIsHTML) {
            msg.setContent(body, "text/html");
        } else {
            msg.setText(body);
        }

        // send the message
        Transport transport = curSess.getTransport();
        transport.connect(username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

    }
}
