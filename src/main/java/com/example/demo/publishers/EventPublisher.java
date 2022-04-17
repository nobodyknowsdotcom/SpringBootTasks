package com.example.demo.publishers;

import com.example.demo.events.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class EventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public EventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    @Transactional
    public void publishCustomEvent(final String message) {
        log.info("Publishing custom event");
        MyEvent customSpringEvent = new MyEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
    @Transactional
    public void publishErrorEvent(final String message) {
        log.info("Publishing error event");
        MyEvent customSpringEvent = new MyEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
        throw new RuntimeException();
    }
}