package com.example.demo.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MyEvent extends ApplicationEvent {
    private final String message;
    private final String code;

    public MyEvent(Object source, String message, String code) {
        super(source);
        this.message = message;
        this.code = code;
    }
}