package com.example.demo;

import com.example.demo.config.ConfigInfo;
import com.example.demo.vehicles.Car;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication{
    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(MyApplication.class, args);
        Car myCar = applicationContext.getBean(Car.class);
        ConfigInfo config = applicationContext.getBean(ConfigInfo.class);
        System.out.println(config);
        System.out.printf("Wheels size is %s\n", myCar.getWheelsSize());
        System.out.printf("Steering wheel size is %s\n", myCar.getSteeringWheelSize());
        myCar.work();

        try {
            System.out.println(applicationContext.getBean("testString"));
            System.out.println(applicationContext.getBean("secondTestString"));
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Test Bean not found!");
        }

        try {
            System.out.println(applicationContext.getBean("isNotDefault"));;
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("This is default config.");
        }
    }
}
