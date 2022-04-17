package com.example.demo;

import com.example.demo.publishers.EventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static EventPublisher eventPublisher;

	public DemoApplication(EventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		eventPublisher.publishCustomEvent("Correct event");
		eventPublisher.publishErrorEvent("IllegalArgumentException event");
	}
}
