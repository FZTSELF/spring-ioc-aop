package com.fzt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
//      ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        //context.addApplicationListener(new ApplicationStartedListner());
        context.refresh();


        UserServiceImpl userService=context.getBean(UserServiceImpl.class);
        UserServiceImpl userService2=context.getBean(UserServiceImpl.class);
        userService.save();
        System.out.println(userService+"----------"+userService2);

//        for(String beanName: context.getBeanDefinitionNames()){
//            System.out.println(beanName);
//        }

        //CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));

//        System.out.println(SingleTonUser.getInstance());
//        System.out.println(SingleTonUser.getInstance());
    }
}
