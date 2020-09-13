package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ReviewApplication {


	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Primary
	@Bean
	public String message(){
		System.out.println("printing message");
		return "HelloSpring";
	}

//	@Bean
//	public String upperCaseMessage(MessageListingService messageListingService){
//		System.out.println("printing UpperCaseMessage");
//		return messageListingService.UpperCase();
//	}

//	@Bean
//	public String lowerCaseMessage(MessageListingService messageListingService){
//		System.out.println("printing LowerCaseMessage");
//		return messageListingService.LowerCase();
//	}

}
