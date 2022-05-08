package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Value("${api.quota}")
    private int apiQuota;
    private int usedQuotas;
    private final Logger logger;

    public MyAspect(){
        this.logger = LoggerFactory.getLogger(this.getClass());
        usedQuotas = 0;
    }

    @Pointcut("@annotation(com.example.demo.annotations.WithRestrictedQuota)")
    public void callAtApiRequest() { }

    @After("callAtApiRequest()")
    public void beforeCallApiRequest(JoinPoint jp) {
        if (usedQuotas >= apiQuota){
            logger.info("Reached maximum api quota.");
            throw new RuntimeException();
        }
        else{
            logger.info("Api was called.");
        }
        usedQuotas ++;
    }
}

