package com.example.appliinsee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.appliopensource" })
public class AppliInseeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppliInseeApplication.class, args);
	}

}
