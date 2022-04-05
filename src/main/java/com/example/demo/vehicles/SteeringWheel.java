package com.example.demo.vehicles;

import lombok.Getter;

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
