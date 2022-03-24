package com.example.demo.vehicles;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Component
public class CarWithSetterInjection{
    private IRollable wheel;
    private IRollable steeringWheel;

    @Autowired
    public void setWheel(IRollable wheel){
        this.wheel = wheel;
    }
    @Autowired
    public void setSteeringWheel(IRollable steeringWheel){
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
}
