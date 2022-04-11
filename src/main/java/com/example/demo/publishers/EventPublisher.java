package com.example.demo.publishers;

import com.example.demo.events.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor=Exception.class)
public class EventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishCustomEvent(final String message, String code) {
        log.info("Publishing custom event");
        MyEvent customSpringEvent = new MyEvent(this, message, code);
        try{
            applicationEventPublisher.publishEvent(customSpringEvent);
        } catch (Exception e){
            log.info("Exception caught, rolling back");
        }

    }
}