package com.fzt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

public class SpringApplication {
    public static void main(String[] args) {
//      ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();


        UserService userService=context.getBean(UserService.class);
        userService.save();

//        for(String beanName: context.getBeanDefinitionNames()){
//            System.out.println(beanName);
//        }

        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
    }
}
