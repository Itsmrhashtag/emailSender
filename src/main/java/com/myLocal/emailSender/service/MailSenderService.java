package com.myLocal.emailSender.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendNewMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
    public void sendEmailWithAttachment(String to, String subject, String htmlTemplatePath, String attachmentPath, Map<String, String> placeholders) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        String htmlContent = readHtmlTemplate(htmlTemplatePath);
        htmlContent = replacePlaceholders(htmlContent, placeholders);
        helper.setText(htmlContent, true);

        Path path = Paths.get(attachmentPath);
        helper.addAttachment(path.getFileName().toString(), new File(attachmentPath));

        mailSender.send(message);
    }

    private String readHtmlTemplate(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private String replacePlaceholders(String content, Map<String, String> placeholders) {
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            content = content.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return content;
    }
}