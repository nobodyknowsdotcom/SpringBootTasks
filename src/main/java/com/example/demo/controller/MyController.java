package com.example.demo.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class MyController {

    @RequestMapping(path="/dosomething", method=RequestMethod.GET)
    public String readTask() {
        return "Api did something.";
    }

}
