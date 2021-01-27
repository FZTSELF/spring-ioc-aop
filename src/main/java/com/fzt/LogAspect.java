package com.fzt;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("@annotation(com.fzt.Transaction)")
    public void pointCut(){

    }

    @Around("@annotation(com.fzt.Transaction)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        Transaction transaction=methodSignature.getMethod().getAnnotation(Transaction.class);
        if(transaction!=null){
            System.out.println(transaction.propagate());
        }

        System.out.println("aspectj before");
        joinPoint.proceed(joinPoint.getArgs());
        System.out.println("aspectj after");
    }
}
