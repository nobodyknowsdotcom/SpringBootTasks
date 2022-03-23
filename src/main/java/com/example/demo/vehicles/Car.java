package com.example.demo.vehicles;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Component
public class Car{
    private Wheel wheel;

    @Autowired
    public Car(Wheel wheel){
        this.wheel = wheel;
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
