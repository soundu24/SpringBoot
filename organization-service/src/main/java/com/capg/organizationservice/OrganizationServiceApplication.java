package com.capg.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Organization Service REST APIs", 
		description = "Organization Service REST APIs Documentation", 
		version = "v1.0", 
		contact = @Contact(
				name = "Soundarya", 
				email = "soundaryashebbar23@gmail.com", 
				url = "https://www.google.com/"),
		license = @License(
				name = "Apache 2.0",
				url = "https://www.google.com/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization-service Doc"
				)
)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
