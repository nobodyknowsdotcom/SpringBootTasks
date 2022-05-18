package com.example.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class MyController {

    @GetMapping("/public/api")
    public String getPublicPage(){
        return "Hello, User!";
    }

    @GetMapping("/admin/api")
    public String getAdminPage(Authentication auth){
        var role = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
                .get(0)
                .split("_")[1];
        var name = auth.getName();
        return String.format("Hello, %s!\nYour roles: %s", role, name);
    }

    @GetMapping("/support/api")
    public String getSupportPage(Authentication auth){
        var role = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
                .get(0)
                .split("_")[1];
        var name = auth.getName();
        return String.format("Hello, %s!\nYour roles: %s", role, name);
    }
}