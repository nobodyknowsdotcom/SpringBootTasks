package com.example.demo.listeners;

import com.example.demo.events.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class TransactionalListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleCustom(MyEvent event) {
        log.info("Received spring custom event " + event.getMessage() + " with code "+Integer.parseInt(event.getCode())+" 'Transactional'");
    }
}
