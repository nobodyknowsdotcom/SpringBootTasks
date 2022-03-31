package com.example.demo.config;

import com.example.demo.vehicles.SteeringWheel;
import com.example.demo.vehicles.Wheel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Dev {
    @Value("${dev.app.name:default}")
    private String appName;
    @Value("${spring.profiles.active:default config}")
    private String configName;
    @Value("${dev.wheel.size:0}")
    private int wheelSize;
    @Value("${dev.steeringwheel.size:0}")
    private int steeringWheelSize;

    @Bean
    public Wheel wheel(){
        return new Wheel(wheelSize){
            @Override
            public void Roll() {
                System.out.println("Wheels are spinning crappy.");
            }
        };
    }
    @Bean
    public SteeringWheel steeringWheel(){
        return new SteeringWheel(steeringWheelSize){
            @Override
            public void Roll(){
                System.out.println("Steering wheel is spinning not bad.");
            }
        };
    }
    @Bean
    @ConditionalOnExpression("!('${spring.profiles.active}'=='{default}')")
    public String isNotDefault(){
        return "This is not default config!";
    }
    @Bean String appName(){
        return appName;
    }
    @Bean String configName(){
        return configName;
    }
}
