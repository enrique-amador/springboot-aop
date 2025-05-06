package com.kikux.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before entering to: " + methodName + " with args: " + args);
    }

    @After("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") //any return
    public void loggerAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After: " + methodName + " with args: " + args);
    }
    @AfterReturning("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") //any return
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After returning: " + methodName + " with args: " + args);
    }
    @AfterThrowing("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") //any return
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After throwing: " + methodName + " with args: " + args);
    }
    @Around("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") //any return
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("The method " + methodName + "with params: " + args);
            result = joinPoint.proceed();
            logger.info("The method " + methodName + "returns: " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error in call of: " + methodName);
            throw e;
        }
        //order of execuction:
        // Around > Before > AfterReturn > After > Around
    }
}
