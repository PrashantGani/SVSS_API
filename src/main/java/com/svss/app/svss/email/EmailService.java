package com.svss.app.svss.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String to, String otp) {
    	try {
    	    SimpleMailMessage message = new SimpleMailMessage();
    	    message.setTo(to);
    	    message.setSubject("Password Reset OTP");
    	    message.setText("Your OTP for password reset is: " + otp);
    	    mailSender.send(message);
    	} catch (MailException e) {
    	    System.err.println("Error sending email to " + to + ": " + e.getMessage());
    	}

    }
}

