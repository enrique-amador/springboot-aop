package com.kikux.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
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

    // @Before("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))") //any return
    // @Before("execution (* *.*(..))") //any packaga any class any return
    // @Before("execution (* com.kikux.curso.springboot.app.aop.springboot_aop..*.*(..))") //any class in project
    @Before("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") //any return
    public void loggerBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before entering to: " + signature + " with args: " + args);
    }

    @After("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") //any return
    public void loggerAfter(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After: " + signature + " with args: " + args);
    }
}
