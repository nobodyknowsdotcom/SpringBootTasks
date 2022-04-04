package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;

public class ConfigInfo {
    private final String configName;
    private final String appName;
    @Autowired
    public ConfigInfo(String configName, String appName) {
        this.configName = configName;
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "configName='" + configName + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
