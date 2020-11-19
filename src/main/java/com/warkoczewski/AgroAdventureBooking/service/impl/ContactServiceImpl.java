package com.warkoczewski.AgroAdventureBooking.service.impl;
import com.warkoczewski.AgroAdventureBooking.config.EmailConfiguration;
import com.warkoczewski.AgroAdventureBooking.dto.ContactDTO;
import com.warkoczewski.AgroAdventureBooking.service.ContactService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private final JavaMailSenderImpl javaMailSender;
    private final EmailConfiguration emailConfiguration;

    public ContactServiceImpl(JavaMailSenderImpl javaMailSender, EmailConfiguration emailConfiguration) {
        this.javaMailSender = javaMailSender;
        this.emailConfiguration = emailConfiguration;
    }

    @Override
    public void sendEmail(ContactDTO contactDTO) {
        createJavaMailSender(contactDTO);

    }
    private void createJavaMailSender(ContactDTO contactDTO) {
        javaMailSender.setHost(this.emailConfiguration.getHost());
        javaMailSender.setPort(this.emailConfiguration.getPort());
        javaMailSender.setUsername(this.emailConfiguration.getUsername());
        javaMailSender.setPassword(this.emailConfiguration.getPassword());

        javaMailSender.send(createMessage(contactDTO));
    }


    private SimpleMailMessage createMessage(ContactDTO contactDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText(contactDTO.getFullName());
        simpleMailMessage.setFrom(contactDTO.getEmailFrom());
        simpleMailMessage.setTo("awarkoczewski@yahoo.com");
        simpleMailMessage.setSubject(contactDTO.getSubject());
        simpleMailMessage.setText(contactDTO.getText());
        return simpleMailMessage;
    }
}
