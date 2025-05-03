package com.kikux.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution (String com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();        
        String args = Arrays.toString(joinPoint.getArgs());
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        logger.info("Before entering to: " + signature + " with args: " + args + " and source: " + sourceLocation);
    }
}
