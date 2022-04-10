package com.example.demo;

import com.example.demo.publishers.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var applicationContext = SpringApplication.run(DemoApplication.class, args);
		var eventPublisher = applicationContext.getBean(EventPublisher.class);
		eventPublisher.publishCustomEvent("Event with correct code", "100");
		eventPublisher.publishCustomEvent("Event with incorrect code", "not a code");
	}

}
