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
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    private void greetingPointcut(){}

    // @Before("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))") //any return
    // @Before("execution (* *.*(..))") //any packaga any class any return
    // @Before("execution (* com.kikux.curso.springboot.app.aop.springboot_aop..*.*(..))") //any class in project
    @Before("greetingPointcut()") //any return
    public void loggerBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before 2 entering to: " + methodName + " with args: " + args);
    }

    @After("greetingPointcut()") //any return
    public void loggerAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After 2: " + methodName + " with args: " + args);
    }

    @AfterReturning("greetingPointcut()") //any return
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After returning 2: " + methodName + " with args: " + args);
    }

    @AfterThrowing("greetingPointcut()") //any return
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();        
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After throwing 2: " + methodName + " with args: " + args);
    }

    @Around("greetingPointcut()") //any return
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("Around2 the method " + methodName + "with params: " + args);
            result = joinPoint.proceed();
            logger.info("Around2 the method " + methodName + "returns: " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error in call of: " + methodName);
            throw e;
        }
        //order of execuction:
        // Around > Before > AfterReturn/AfterThrowing > After > Around
    }
}
