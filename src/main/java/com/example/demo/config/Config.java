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
    private String envVariable;
    private int wheelSize;
    private int steeringWheelSize;

    @Bean
    public Wheel wheel(){
        return new Wheel(wheelSize){
            @Override
            public void roll() {
                System.out.println("Wheels are rolling.");
            }
        };
    }
    @Bean
    public SteeringWheel steeringWheel(){
        return new SteeringWheel(steeringWheelSize){
            @Override
            public void roll(){
                System.out.println("Steering wheel is rolling.");
            }
        };
    }
    @Profile("test")
    @Bean
    public ConfigInfo configInfo(){
        return new ConfigInfo(configName, appName);
    }
    @Bean
    @ConditionalOnBean(ConfigInfo.class)
    public Wheel testWheel(){
        return new Wheel(wheelSize*3){
            @Override
            public void roll() {
                System.out.println("Wheels are rolling.");
            }
        };
    }
    @Bean
    @ConditionalOnExpression("!'${my.envVariable}'.equals('default')")
    public String isNotDefault(){
        return "my.envVariable is default now.";
    }
}
