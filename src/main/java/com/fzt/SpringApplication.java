package com.fzt;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class SpringApplication {
    public static void main(String[] args) throws LifecycleException {




//      ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");

//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//        context.register(AppConfig.class);
//        //context.addApplicationListener(new ApplicationStartedListner());
//        context.refresh();

//        UserDao userDao=context.getBean(UserDao.class);
//        UserDao userDao= (UserDao) context.getBean("userDao");
//        System.out.println(userDao.getClass());
//        userDao.save();

//        UserService userService= (UserService) context.getBean("userService");
//        System.out.println(userService.getClass());
//        userService.save();

//        UserServiceImpl userService=context.getBean(UserServiceImpl.class);
//        UserServiceImpl userService2=context.getBean(UserServiceImpl.class);
//        userService.save();
//        System.out.println(userService+"----------"+userService2);

//        for(String beanName: context.getBeanDefinitionNames()){
//            System.out.println(beanName);
//        }

        //CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));

//        System.out.println(SingleTonUser.getInstance());
//        System.out.println(SingleTonUser.getInstance());



       // dispatcherServlet.setApplicationContext();


        Tomcat tomcat=new Tomcat();
        Connector connector=new Connector();
        connector.setPort(9999);
        tomcat.getService().addConnector(connector);

        StandardContext standardContext=new StandardContext();
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        standardContext.setPath("/mvc");
        tomcat.getHost().addChild(standardContext);

        AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MvcConfig.class);
        webApplicationContext.setServletContext(standardContext.getServletContext());
        webApplicationContext.refresh();
        DispatcherServlet dispatcherServlet=new DispatcherServlet(webApplicationContext);

        tomcat.addServlet("/mvc","dispacher",dispatcherServlet);
        standardContext.addServletMappingDecoded("/","dispacher");

        tomcat.start();
        tomcat.getServer().await();

    }
}
