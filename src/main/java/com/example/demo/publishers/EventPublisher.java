package com.example.demo.publishers;

import com.example.demo.events.MyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor=Exception.class)
@Service
public class EventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishCustomEvent(final String message, String code) {
        System.out.println("Publishing custom event");
        MyEvent customSpringEvent = new MyEvent(this, message, code);
        try{
            applicationEventPublisher.publishEvent(customSpringEvent);
        } catch (Exception e){
            System.out.println("Exception caught, rolling back");
        }

    }
}