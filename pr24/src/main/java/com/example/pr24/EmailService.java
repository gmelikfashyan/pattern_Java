package com.example.pr24;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    private String HOST_NAME = "smtp.yandex.ru";
    private int PORT_NAME = 465;
    private String USER_NAME = "gevorkmelikfashyan@yandex.ru";
    private String PASSWORD = "Gevork2611";

    @Async
    public void sendEmail(Footballer footballer) {
        String adressee = "gmelikfashyan@gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST_NAME);
        props.put("mail.smtp.port", PORT_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_NAME, PASSWORD);}});
        try {
            Message message = new MimeMessage(session);
            message.setSubject("Добавлен элемент");
            message.setText("Добавлен футболист " + footballer.toString());
            message.setFrom(new InternetAddress(USER_NAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adressee));
            Transport.send(message);
            System.out.println("Письмо отправлено");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
