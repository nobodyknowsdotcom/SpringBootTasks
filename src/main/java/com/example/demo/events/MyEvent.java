package com.example.demo.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MyEvent extends ApplicationEvent {
    private final String message;
    private final Throwable exception;

    public MyEvent(Object source, String message, Throwable exception) {
        super(source);
        this.message = message;
        this.exception = exception;
    }
}