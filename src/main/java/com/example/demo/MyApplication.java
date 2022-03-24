package com.example.demo;

import com.example.demo.vehicles.Car;
import com.example.demo.vehicles.CarWithFieldInjection;
import com.example.demo.vehicles.CarWithSetterInjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication{
    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(MyApplication.class, args);
        CarWithSetterInjection setterCar = applicationContext.getBean(CarWithSetterInjection.class);
        Car constructorCar = applicationContext.getBean(Car.class);
        CarWithFieldInjection fieldCar = applicationContext.getBean(CarWithFieldInjection.class);

        setterCar.Work();
        constructorCar.Work();
        fieldCar.Work();
    }
}
