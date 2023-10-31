package org.example.email;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class GEmailSender {
    public boolean sendEmail(String to, String from, String subject, String text){
        boolean flag = false;

        //logic
        //Creating and adding smtp properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "from_userid"; //sender userid from email id before @gmail.com
        String password = "xxxx xxxx xxxx xxxx";
        // 16-digit code from app passwords in google manager.
        // Condition applied that the email should be 2-factor authentication verified
        // Otherwise You won't get to see App Passwords menu

        //Session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
