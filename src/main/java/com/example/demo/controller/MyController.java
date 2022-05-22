package com.example.demo.controller;

import com.example.demo.dto.MyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MyController {

    @PostMapping("/addid")
    public ResponseEntity<MyDto> myGreeting(@RequestBody MyDto input){
        return new ResponseEntity<>(input, HttpStatus.OK);
    }
}
