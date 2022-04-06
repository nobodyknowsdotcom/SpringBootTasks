package com.example.demo.listeners;

import com.example.demo.events.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component

public class SyncListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage() + " 'Sync'");
    }
}