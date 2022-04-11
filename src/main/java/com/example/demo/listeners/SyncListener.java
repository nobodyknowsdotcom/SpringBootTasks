package com.example.demo.listeners;

import com.example.demo.events.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SyncListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info("Received spring custom event - " + event.getMessage() + " 'Sync'");
    }
}