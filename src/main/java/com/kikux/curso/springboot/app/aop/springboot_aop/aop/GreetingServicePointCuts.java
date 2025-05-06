package com.kikux.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingServicePointCuts {

    @Pointcut("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingPointcut(){} //it could be protected as well

    @Pointcut("execution (* com.kikux.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingFooPointcut(){}
}
