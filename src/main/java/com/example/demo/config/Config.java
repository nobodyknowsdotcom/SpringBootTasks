package com.example.demo.config;

import com.example.demo.vehicles.SteeringWheel;
import com.example.demo.vehicles.Wheel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.vehicles")
public class Config {
    @Bean
    public Wheel wheel(){
        return new Wheel();
    }
    @Bean
    public SteeringWheel steeringWheel(){
        return new SteeringWheel();
    }
}
