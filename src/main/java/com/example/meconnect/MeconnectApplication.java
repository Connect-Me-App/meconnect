package com.example.meconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.meconnect.*")
@ComponentScan({ "com.example.meconnect.controller", "com.example.meconnect.service" })
public class MeconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeconnectApplication.class, args);
	}

}
