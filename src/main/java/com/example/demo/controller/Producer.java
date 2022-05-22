package com.example.demo.controller;

import javax.jms.Queue;

import com.example.demo.dto.MyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/produce")
public class Producer {

    private final JmsTemplate jmsTemplate;

    private final Queue queue;

    public Producer(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    @PostMapping("/message")
    public MyDto sendMessage(@RequestBody MyDto data) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String studentAsJson = mapper.writeValueAsString(data);

            jmsTemplate.convertAndSend(queue, studentAsJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}