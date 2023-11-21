package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MailController {


	Logger logger= LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private EmailSenderService service;
	
	@PostMapping("/send")
	public String triggerMail( @RequestBody MailRequest mailRequest) throws MessagingException {
		logger.info("method hit"+mailRequest);
		service.sendEmailWithAttachment(mailRequest.getToEmail(), mailRequest.getBody(), mailRequest.getSubject(),mailRequest.getAttachment());
		return "Message send to "+mailRequest.getToEmail();
	}
}
