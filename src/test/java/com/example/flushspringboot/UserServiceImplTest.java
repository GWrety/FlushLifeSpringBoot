package com.example.flushspringboot;

import com.example.flushspringboot.Service.UserService;
import com.example.flushspringboot.Utils.User;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    UserService userServiceImp;
    @Test
    void enrollUser() {
        User tempuser=new User();
        tempuser.setUsername("admin");
        tempuser.setUseremail("264@qq.com");
        tempuser.setUserpassword("admin");
        tempuser.setUserpicture("https://profile.csdnimg.cn/7/9/8/1_flawless22222");
        userServiceImp=new UserService();
        userServiceImp.enrollUser(tempuser);
    }
}