package com.example.demo.vehicles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor

public class SteeringWheel implements IRollable{
    @Override
    public void Roll() {
        System.out.println("Steering wheel is rolling.");
    }
}
