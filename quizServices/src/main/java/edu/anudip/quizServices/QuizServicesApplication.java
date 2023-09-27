package edu.anudip.quizServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServicesApplication.class, args);
		System.out.println("Quiz  App is Running.......");
	}

}
