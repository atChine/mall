package com.atgao.mall.service.impl;

import com.atgao.mall.pojo.User;
import com.atgao.mall.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest  {
    @Autowired
    private UserService userService;
    @Test
    void register() {
        User user = new User(1, "admin", "1234", "12323@da.com", 1);
        userService.register(user);
    }
}