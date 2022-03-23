package com.example.demo;

import com.example.demo.config.Config;
import com.example.demo.vehicles.Car;
import com.example.demo.vehicles.CarWithFieldInjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
        ApplicationContext javaConfigContext = new AnnotationConfigApplicationContext(Config.class);

        Car constructorCar = javaConfigContext.getBean(Car.class);
        CarWithFieldInjection fieldCar = javaConfigContext.getBean(CarWithFieldInjection.class);
        constructorCar.getWheel().Roll();
        constructorCar.getSteeringWheel().Roll();
    }
}
