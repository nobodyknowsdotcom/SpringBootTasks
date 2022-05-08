package com.example.demo.controller;

import com.example.demo.dto.MyDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class MyController {
    private final ObjectMapper objectMapper;

    public MyController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/getheaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        var headersList= new ArrayList<String>();
        headers.forEach((key, value) -> headersList.add(String.format("Header '%s' = %s", key, value)));
        return new ResponseEntity<>(String.join("\n", headersList), HttpStatus.OK);
    }

    @GetMapping("/addid")
    public ResponseEntity<MyDto> myGreeting(@RequestBody MyDto input){
        return new ResponseEntity<>(input, HttpStatus.OK);
    }
}
