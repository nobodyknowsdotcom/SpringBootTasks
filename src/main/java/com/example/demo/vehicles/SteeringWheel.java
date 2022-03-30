package com.example.demo.vehicles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
public class SteeringWheel implements IRollable{
    private int size;
    @Override
    public void Roll() {
        System.out.println("Steering wheel is rolling.");
    }
}
