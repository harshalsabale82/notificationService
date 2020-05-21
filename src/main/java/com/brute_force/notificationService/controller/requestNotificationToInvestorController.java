package com.brute_force.notificationService.controller;

import com.brute_force.notificationService.repository.requestNotificationToMentorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@RestController
@RequestMapping("/investor/sendmail")
public class requestNotificationToInvestorController {
    private requestNotificationToMentorRepository requestnotificationtomentorrepository;

    public requestNotificationToInvestorController(requestNotificationToMentorRepository requestnotificationtomentorrepository) {
        this.requestnotificationtomentorrepository = requestnotificationtomentorrepository;
    }

    @GetMapping("/{id}")
    private void sendMail(@PathVariable("id") String id)throws AddressException, MessagingException, IOException {
        final HashMap name = new HashMap();
        this.requestnotificationtomentorrepository.findById(id).map(requestNotificationToMentor -> {
            String name1 = requestNotificationToMentor.getFirstName();
            String email1 = requestNotificationToMentor.getEmail();
            name.put("name",name1);
            name.put("email",email1);
            return name;
        });
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        try {
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("startupnotification1@gmail.com","ussahcgjexmzkqyx");
                        }
                    });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("startupnotification1@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress((String) name.get("email")));
            message.setSubject("Test Notification Service");
            message.setText("Hello,you have a connection request from the "+name.get("name"));
            Transport.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }


    }
}
