package com.fzt;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class ProxyUserServiceTest {
    @Test
    public void testProxyUserService(){
        ProxyUserService proxyUserService=new ProxyUserService(new UserServiceImpl());
        proxyUserService.save();
    }



    @Test
    public void testProxyUserServiceJdk(){
        ProxyUserServiceJdk proxyUserServiceJdk=new ProxyUserServiceJdk(new UserServiceImpl());
        UserService userService= (UserService) proxyUserServiceJdk.getProxy();
        //System.out.println(userService.getClass());
        userService.save();
    }

    @Test
    public void testCglibProxy(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new CglibMethodProxy());
        UserDao userDao= (UserDao) enhancer.create();
        System.out.println(userDao.getClass());
        userDao.save();
    }
}
