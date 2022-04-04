package com.example.demo.config;

import com.example.demo.vehicles.SteeringWheel;
import com.example.demo.vehicles.Wheel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class Prod {
    @Value("${prod.app.name:default}")
    private String appName;
    @Value("${spring.profiles.active:default config}")
    private String configName;
    @Value("${prod.wheel.size:0}")
    private int wheelSize;
    @Value("${prod.steeringwheel.size:0}")
    private int steeringWheelSize;

    @Bean
    public Wheel wheel(){
        return new Wheel(wheelSize){
            @Override
            public void roll(){
                System.out.println("Wheels are spinning greatly!");
            }
        };
    }
    @Bean
    public SteeringWheel steeringWheel(){
        return new SteeringWheel(steeringWheelSize){
            @Override
            public void roll(){
                System.out.println("Steering wheel is spinning very cool!");
            }
        };
    }
    @Bean
    @ConditionalOnExpression("!('${spring.profiles.active}'=='{default}')")
    public String isNotDefault(){
        return "This is not default config!";
    }
    @Bean
    public ConfigInfo configInfo(){
        return new ConfigInfo(configName, appName);
    }
}
