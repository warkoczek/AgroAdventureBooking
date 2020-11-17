package com.warkoczewski.AgroAdventureBooking.service.impl;

import com.warkoczewski.AgroAdventureBooking.config.EmailConfiguration;
import com.warkoczewski.AgroAdventureBooking.dto.ContactDTO;
import com.warkoczewski.AgroAdventureBooking.service.ContactService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class ContactServiceImpl implements ContactService {
    private final JavaMailSenderImpl javaMailSender;
    private final SimpleMailMessage simpleMailMessage;

    public ContactServiceImpl(JavaMailSenderImpl javaMailSender, SimpleMailMessage simpleMailMessage) {
        this.javaMailSender = javaMailSender;
        this.simpleMailMessage = simpleMailMessage;
    }

    @Override
    public void sendEmail(ContactDTO contactDTO) {
        createMessage(contactDTO);
        javaMailSender.send(simpleMailMessage);
    }

    private void createMessage(ContactDTO contactDTO) {
        simpleMailMessage.setText(contactDTO.getFullName());
        simpleMailMessage.setFrom(contactDTO.getEmailFrom());
        simpleMailMessage.setTo("awarkoczewski@yahoo.com");
        simpleMailMessage.setSubject(contactDTO.getSubject());
        simpleMailMessage.setText(contactDTO.getText());
    }
}
