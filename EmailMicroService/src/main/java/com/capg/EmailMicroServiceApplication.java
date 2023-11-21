package com.capg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class EmailMicroServiceApplication {

	
//	@Autowired
//	private EmailSenderService service;
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmailMicroServiceApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() throws MessagingException {
//	service.sendEmail("soundaryashebbar23@gmail.com", "this is mail from spring boot", "email integration" );
//		
//		service.sendEmailWithAttachment("soundaryashebbar23@gmail.com", "this is email with attachment", "attachment", "C:\\Users\\soundars\\casestudy.txt");
//	}
}
