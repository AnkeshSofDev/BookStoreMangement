package com.bookStoreMangement.service;



import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.bookStoreMangement.entity.Email;



@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void SendMail(Email em) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			helper.setFrom("interviewkrhub.786@gmail.com");
			
			helper.setTo(em.getTo());
			helper.setSubject(em.getSubject());
			helper.setText(em.getMessage());
			
			javaMailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
