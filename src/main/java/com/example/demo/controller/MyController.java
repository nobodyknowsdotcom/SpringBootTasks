package com.example.demo.controller;

import com.example.demo.dto.MyInput;
import com.example.demo.dto.MyOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Controller
public class MyController {
    @GetMapping("/greeting/{name}")
    public String myGreeting(Model model,@PathVariable String name) {
        model.addAttribute("user.name", name);
        return "greeting";
    }
    @GetMapping("/getheaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        var headersList= new ArrayList<String>();
        headers.forEach((key, value) -> headersList.add(String.format("Header '%s' = %s", key, value)));
        return new ResponseEntity<>(String.join("\n", headersList), HttpStatus.OK);
    }
    @PostMapping("/greeting")
    public ResponseEntity<MyOutput> myPostGreeting(@RequestBody MyInput input) {
        return new ResponseEntity<>(new MyOutput(input.getGreet() + " " + input.getName() + "!"), HttpStatus.OK);
    }
}
