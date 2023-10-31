package org.example;

import org.example.email.GEmailSender;

public class App {
    public static void main(String[] args) {

        GEmailSender gEmailSender = new GEmailSender();
        String to ="to@gmail.com"; //Receiver email
        String from ="from@gmail.com"; //Sender email
        String subject ="Sending email using Java SMTP"; //Subject
        String text ="Mailed you through Java code as SMTP successfully. Hurray!"; //Content in email
        boolean b = gEmailSender.sendEmail(to,from,subject,text);
        if(b){
            System.out.println("Email sent successfully!");
        } else{
            System.out.println("Error sending a email!");
        }

    }
}