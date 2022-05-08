package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyDto {
    @JsonProperty("price")
    private double price;
    @JsonProperty("info")
    private Info info;

}
