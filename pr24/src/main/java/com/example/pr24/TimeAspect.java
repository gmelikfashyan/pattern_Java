package com.example.pr24;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeAspect {
    private long start;

    @Before("execution(* com.example.pr20.FootballerService.*(..))")
    public void executionBefore() {
        start = System.currentTimeMillis();
    }

    @After("execution(* com.example.pr20.FootballerService.*(..))")
    public void executionAfter(JoinPoint joinPoint) {
        long allTime = System.currentTimeMillis() - start;
        log.info("Время выполнения метода: " + joinPoint.getSignature() + " " + allTime + " мс");
    }
}
