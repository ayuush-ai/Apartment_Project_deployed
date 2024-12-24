package com.example.Java_guides_thymeleaf_delete_it_after_completion.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Method to send email to a list of recipients
    public void sendEmailToUsers(List<String> emails, String subject, String text) {
        for (String email : emails) {
            sendEmail(email, subject, text);
        }
    }

    // Helper method to send a single email
    private void sendEmail(String toEmail, String subject, String text) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("your-email@gmail.com");  // Your email address
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(text, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}