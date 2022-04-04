package com.example.demo.config;

import com.example.demo.vehicles.SteeringWheel;
import com.example.demo.vehicles.Wheel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class Test {
    @Value("${test.app.name:default}")
    private String appName;
    @Value("${spring.profiles.active:default config}")
    private String configName;
    @Value("${test.wheel.size:0}")
    private int wheelSize;
    @Value("${test.steeringwheel.size:0}")
    private int steeringWheelSize;

    @Bean
    @ConditionalOnExpression("'${spring.profiles.active}'.equals('test')")
    public Wheel testWheel(){
        return new Wheel(wheelSize){
            @Override
            public void roll() {
                System.out.println("Wheels are in the test mode.");
            }
        };
    }
    @Bean
    public Wheel wheel(){
        return new Wheel(wheelSize){
            @Override
            public void roll() {
                System.out.println("Wheels are in the test mode.");
            }
        };
    }
    @Bean
    @ConditionalOnBean(Wheel.class)
    public SteeringWheel steeringWheel(){
        return new SteeringWheel(steeringWheelSize){
            @Override
            public void roll(){
                System.out.println("Steering wheel is in the testing mode.");
            }
        };
    }
    @Bean
    @ConditionalOnExpression("'${spring.profiles.active}'!='{default}'")
    public String isNotDefault(){
        return "This is not default config!";
    }
    @Bean
    public ConfigInfo configInfo(){
        return new ConfigInfo(configName, appName);
    }
}
