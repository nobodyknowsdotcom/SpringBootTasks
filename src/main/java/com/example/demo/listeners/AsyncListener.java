package com.example.demo.listeners;

import com.example.demo.events.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncListener implements ApplicationListener<MyEvent> {
    @Async
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info("Received spring custom event - " + event.getMessage() + " 'Async'");
    }
}