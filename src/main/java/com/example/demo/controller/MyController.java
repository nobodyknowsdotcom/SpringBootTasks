package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class MyController {
    private final ObjectMapper mapper;

    public MyController(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/getheaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        var headersList= new ArrayList<String>();
        headers.forEach((key, value) -> headersList.add(String.format("Header '%s' = %s", key, value)));
        return new ResponseEntity<>(String.join("\n", headersList), HttpStatus.OK);
    }

    @GetMapping("/addid")
    public ResponseEntity<JsonNode> myGreeting(@RequestBody String input) throws JsonProcessingException {
        JsonNode rootNode = mapper.readTree(input);
        var locatedNode = rootNode.path("info");
        ((ObjectNode) locatedNode).put("id", getRandomNumber(0, Integer.MAX_VALUE));
        return new ResponseEntity<>(rootNode, HttpStatus.OK);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
