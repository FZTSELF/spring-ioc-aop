package com.fzt;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {

    @Transaction(propagate = "11111")
    public void save() {
        System.out.println("UserDao-save()");
    }
}
