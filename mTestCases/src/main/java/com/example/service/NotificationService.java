package com.example.service;


import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
/*
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user, String pwd) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("lisa.asil.k@googlemail.com");
        mail.setSubject("Ihr neuer Account für das Projektron-Testverwaltungstool!");
        mail.setText("Willkommen beim Projektron Testverwaltungstool! \n\n" +
                "Sie können sich unter folgendem Link mit dem untenstehenden Passwort einloggen. \n"+
                "Wir empfehlen, das Passwort nach dem Einloggen in ein eigenes Passwort zu ändern. \n\n"+
                "Link zum Einloggen: http://www.projektrontestcases.de/user/login \n"+
                "Passwort: "+ pwd);

        javaMailSender.send(mail);
    }
     */
}
