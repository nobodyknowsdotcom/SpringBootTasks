package com.example.demo.listeners;

import com.example.demo.events.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Transactional
public class TransactionalListener {
    private static final Logger LOG = LoggerFactory.getLogger(MyEvent.class);
    @EventListener(MyEvent.class)
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleCustom(MyEvent event) {
        System.out.println("Received spring custom event " + event.getMessage() + " with code "+Integer.parseInt(event.getCode())+" 'Transactional'");
    }
}
