package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class Info {
    private Random random;
    @JsonProperty("id")
    private int id;
    @JsonProperty("date")
    private String date;

    public Info(){
        this.random = new Random();
        this.id = random.nextInt(Integer.MAX_VALUE);
    }
}
