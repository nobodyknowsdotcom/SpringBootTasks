package com.example.demo.consumers;

import com.example.demo.dto.MyDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/consume")
public class MyConsumer {

    private final JmsTemplate jmsTemplate;

    private final Queue queue;

    public MyConsumer(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    @GetMapping("/message")
    public MyDto consumeMessage() {

        MyDto data = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonMessage = (String) jmsTemplate.receiveAndConvert(queue);
            data = mapper.readValue(jsonMessage, MyDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}