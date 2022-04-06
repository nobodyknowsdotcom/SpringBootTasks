package com.example.demo;

import com.example.demo.publishers.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var applicationContext = SpringApplication.run(DemoApplication.class, args);
		var eventPublisher = applicationContext.getBean(EventPublisher.class);
		eventPublisher.publishCustomEvent("Custom event", new StackOverflowError());
	}

}
