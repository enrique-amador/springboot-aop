package com.kikux.curso.springboot.app.aop.springboot_aop.services;

public interface GreetingService {
    String sayHello(String name, String phrase);
    String sayHelloError(String name, String phrase);
}
