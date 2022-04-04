package com.example.demo.vehicles;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Component
public class Car{
    private final Wheel wheels;
    private final SteeringWheel steeringWheel;

    @Autowired
    public Car(@Qualifier("wheel") Wheel wheel, @Qualifier("steeringWheel") SteeringWheel steeringWheel){
        this.wheels = wheel;
        this.steeringWheel = steeringWheel;
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("I`m dead :(");
    }
    @PostConstruct
    public void onCreate(){
        System.out.println("I`m alive!");
    }

    public void work(){
        wheels.roll();
        steeringWheel.roll();
    }

    public int getWheelsSize(){
        return this.wheels.getSize();
    }

    public int getSteeringWheelSize(){
        return steeringWheel.getSize();
    }
}
