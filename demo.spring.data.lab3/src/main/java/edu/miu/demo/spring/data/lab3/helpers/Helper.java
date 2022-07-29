package edu.miu.demo.spring.data.lab3.helpers;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Helper {

    @Pointcut("@annotation(edu.miu.demo.spring.data.lab3.helpers.HelloWorld)")
    public void helloWorld(){}

    @Before("helloWorld()")
    public void print(JoinPoint joinPoint){

        System.out.println("Hello World ");
    }



}