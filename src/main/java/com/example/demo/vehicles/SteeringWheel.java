package com.example.demo.vehicles;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SteeringWheel extends Rollable{
    public SteeringWheel(int size){
        super(size);
    }
    @Override
    public void roll() {
        System.out.println("Steering wheel is rolling.");
    }
}
