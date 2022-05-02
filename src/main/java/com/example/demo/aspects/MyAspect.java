package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Value("${api.quota}")
    private int apiQuota;
    private int usedQuotas = 0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void callAtMyServicePublic() { }

    @After("callAtMyServicePublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        if (usedQuotas >= apiQuota){
            logger.info("Reached maximum api quota.");
            throw new RuntimeException();
        }
        else{
            logger.info("Api was called");
        }
        usedQuotas ++;
    }
}

