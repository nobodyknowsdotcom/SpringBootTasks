package Vehicles;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CarWithFieldInjection {
    @Autowired
    private Wheel wheel;

    public void Ride(){
        System.out.println("I`m riding!");
    }
}
