package com.kikux.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayHello(String name, String phrase) {
        String greeting = phrase + " " + name;
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError(String name, String phrase) {
        throw new RuntimeException("some Error");
    }

}
