package com.example.demo.controller;

import com.example.demo.dto.MyInput;
import com.example.demo.dto.MyOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    @GetMapping("/greeting/{name}")
    public String myGreeting(Model model,@PathVariable String name) {
        model.addAttribute("user.name", name);
        return "greeting";
    }
    @PostMapping("/greeting")
    public ResponseEntity<MyOutput> myPostGreeting(@RequestBody MyInput input) {
        return new ResponseEntity<>(new MyOutput(input.getGreet() + " " + input.getName() + "!"), HttpStatus.OK);
    }
}
