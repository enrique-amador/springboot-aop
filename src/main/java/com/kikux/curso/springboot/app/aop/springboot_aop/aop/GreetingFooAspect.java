package com.kikux.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) //this makes this aspect runs first
@Component
@Aspect
public class GreetingFooAspect {

    @Pointcut("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    private void greetingFooPointcut(){}

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Before("greetingFooPointcut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before1 entering to: " + methodName + " with args: " + args);
    }

    @After("greetingFooPointcut()") //any return
    public void loggerAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After1: " + methodName + " with args: " + args);
    }
}
