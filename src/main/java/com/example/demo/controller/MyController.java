package com.example.demo.controller;

import com.example.demo.annotations.WithRestrictedQuota;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class MyController {

    @WithRestrictedQuota
    @GetMapping(path="/dosomething")
    public String apiRequest() {
        return "Api did something.";
    }

}
