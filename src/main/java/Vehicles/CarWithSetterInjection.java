package Vehicles;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CarWithSetterInjection {
    private Wheel wheel;

    @Autowired
    public void setWheel(Wheel wheel){
        this.wheel = wheel;
    }

    public void Ride(){
        System.out.println("I`m riding!");
    }
}
