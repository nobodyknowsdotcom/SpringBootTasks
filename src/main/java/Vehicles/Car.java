package Vehicles;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Getter
@Component
public class Car {
    private Wheel wheel;

    @Autowired
    public Car(Wheel wheel){
        this.wheel = wheel;
    }
    public void Ride(){
        System.out.println("I`m riding!");
    }
    @PreDestroy
    public void onDestroy(){
        System.out.println("I`m not riding :(");
    }
}
