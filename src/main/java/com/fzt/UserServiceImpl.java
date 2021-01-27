package com.fzt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
//        Date start=new Date();
//        userDao.save();
//        Date end=new Date();
//        System.out.println(end.getTime()-start.getTime());
        update();
        System.out.println("service save");
    }

    @Override
    public void update() {
        System.out.println("service update");
    }
}
