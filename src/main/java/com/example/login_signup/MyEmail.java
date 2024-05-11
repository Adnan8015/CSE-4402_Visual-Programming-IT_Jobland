package com.example.login_signup;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;


public class MyEmail
{
    public static int randomNumber;

    public static void Email(String mail) throws Exception {

//        String uniqueID = UUID.randomUUID().toString();

        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocol","smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("adnanahmad8015@gmail.com","edtvxbdjumifylxf");
            }
        });

        Message message = new MimeMessage(session);

        message.setSubject("Your Verification Code");
        int min = 100000; // minimum value
        int max = 999999; // maximum value

        // create an instance of the Random class
        Random random = new Random();

        // generate a random integer between min and max (inclusive)
        randomNumber = random.nextInt(max - min + 1) + min;
        message.setText(Integer.toString(randomNumber));
        Address addressTo = new InternetAddress(mail);
        message.setRecipient(Message.RecipientType.TO, addressTo);

        Transport.send(message);
    }
}