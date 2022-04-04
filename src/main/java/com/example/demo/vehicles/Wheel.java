package com.example.demo.vehicles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Wheel extends Rollable{
    public Wheel(int size){
        super(size);
    }
}
