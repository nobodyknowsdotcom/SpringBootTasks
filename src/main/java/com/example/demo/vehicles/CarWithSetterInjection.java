package com.example.demo.vehicles;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Component
public class CarWithSetterInjection{
    private IRollable wheel2;
    private IRollable steeringWheel2;

    @Qualifier("wheel")
    @Autowired
    public void setWheel(IRollable wheel){
        this.wheel2 = wheel;
    }
    @Qualifier("steeringWheel")
    @Autowired
    public void setSteeringWheel(IRollable steeringWheel){
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
