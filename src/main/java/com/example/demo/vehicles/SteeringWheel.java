package com.example.demo.vehicles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SteeringWheel extends Rollable{
    public SteeringWheel(int size){
        super(size);
    }
    @Override
    public void Roll() {
        System.out.println("Steering wheel is rolling.");
    }
}
