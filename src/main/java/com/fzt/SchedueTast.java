package com.fzt;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SchedueTast implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("scheueTask init finish");
    }


}
