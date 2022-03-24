package com.example.demo.vehicles;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Setter
@Component
public class CarWithFieldInjection{
    @Qualifier("wheel")
    @Autowired
    private IRollable wheel2;
    @Qualifier("steeringWheel")
    @Autowired
    private IRollable steeringWheel2;

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
