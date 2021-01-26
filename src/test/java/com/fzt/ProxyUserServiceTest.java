package com.fzt;
import org.junit.Test;
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
        userService.save();
    }
}
