package com.fzt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ContextResource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

//@Component
//public class ApplicationStartedListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        System.out.println(event.getTimestamp());
//        ApplicationContext context=event.getApplicationContext();
//        CollectionUtils.arrayToList(context.getBeanDefinitionNames()).forEach(item-> System.out.println(item));
//    }
//}
