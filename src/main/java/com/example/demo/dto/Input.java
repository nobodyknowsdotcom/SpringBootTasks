package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonRootName(value = "info")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Input {
    String price;
    String date;
}
