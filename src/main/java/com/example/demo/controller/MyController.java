package com.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Controller
public class MyController {
    @GetMapping("/addid")
    public ResponseEntity<String> myGreeting(@RequestBody JsonNode input) {
        return new ResponseEntity<>(input.findValues("date").toString(), HttpStatus.OK);
    }
    @GetMapping("/getheaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        var headersList= new ArrayList<String>();
        headers.forEach((key, value) -> headersList.add(String.format("Header '%s' = %s", key, value)));
        return new ResponseEntity<>(String.join("\n", headersList), HttpStatus.OK);
    }
}
