package com.example.demo.listeners;

import com.example.demo.events.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncListener implements ApplicationListener<MyEvent> {
    @Async
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage() + " 'Async'");
    }
}