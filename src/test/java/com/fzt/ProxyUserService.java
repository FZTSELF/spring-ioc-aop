package com.fzt;

import java.util.Date;

public class ProxyUserService implements UserService {
    private UserService userService;

    public ProxyUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void save() {
        System.out.println("before");
        Date start=new Date();
        userService.save();
        Date end=new Date();
        System.out.println("after");
        System.out.println("save()执行时间: "+ (end.getTime()-start.getTime()));
    }

    @Override
    public void update() {
        System.out.println("before");
        Date start=new Date();
        userService.update();
        Date end=new Date();
        System.out.println("after");
        System.out.println("update()执行时间: "+ (end.getTime()-start.getTime()));
    }
}
