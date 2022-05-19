package com.example.demo.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Endpoint(id="custom")
@Component
public class MyEndpoint {
    @ReadOperation
    public String dateEndpoint(@Selector String name){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return String.format("Hello, %s.\nThanks for visiting my custom endpoint!\nCurrent date is %s", name, dtf.format(now));
    }
}