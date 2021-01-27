package com.fzt;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class CglibMethodProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Date start=new Date();
        methodProxy.invokeSuper(target,args);
        Date end=new Date();
        System.out.println("after");
        System.out.println("执行时间: "+ (end.getTime()-start.getTime()));
        return null;
    }
}
