package com.kafkasandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSandboxApplication.class, args);
	}

}
