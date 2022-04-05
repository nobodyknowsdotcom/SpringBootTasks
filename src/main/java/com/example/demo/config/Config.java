package com.example.demo.config;

import com.example.demo.vehicles.SteeringWheel;
import com.example.demo.vehicles.Wheel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix="my")
public class Config {
    private String appName;
    private String configName;
    private int wheelSize;
    private int steeringWheelSize;

    @Bean
    @Profile({"dev", "prod", "test", "default"})
    public Wheel wheel(){
        return new Wheel(wheelSize){
            @Override
            public void roll() {
                System.out.println("Wheels are rolling.");
            }
        };
    }
    @Bean
    @Profile({"dev", "prod", "test", "default"})
    public SteeringWheel steeringWheel(){
        return new SteeringWheel(steeringWheelSize){
            @Override
            public void roll(){
                System.out.println("Steering wheel is rolling.");
            }
        };
    }
    @Bean
    @Profile({"dev", "prod", "test", "default"})
    public ConfigInfo configInfo(){
        return new ConfigInfo(configName, appName);
    }
    @Bean
    @Profile("test")
    public String testString(){
        return "First test string is born!";
    }
    @Bean
    @Profile({"test"})
    @ConditionalOnBean(String.class)
    public String secondTestString(){
        return "Second test string is born!";
    }
    @Bean
    @ConditionalOnExpression("!'${spring.profiles.active}'.equals('default')")
    public String isNotDefault(){
        return "This is not default config!";
    }
}
