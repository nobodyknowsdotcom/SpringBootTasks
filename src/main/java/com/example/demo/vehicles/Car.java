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
    @Qualifier("wheel")
    private IRollable wheel2;
    @Qualifier("steeringWheel")
    private IRollable steeringWheel2;

    @Autowired
    public Car(IRollable wheel, IRollable steeringWheel){
        this.wheel2 = wheel;
        this.steeringWheel2 = steeringWheel;
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("I`m dead :(");
    }
    @PostConstruct
    public void onCreate(){
        System.out.println("I`m alive!");
    }

    public void Work(){
        wheel2.Roll();
        steeringWheel2.Roll();
    }
}
