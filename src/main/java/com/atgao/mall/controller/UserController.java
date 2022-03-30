package com.atgao.mall.controller;

import com.atgao.mall.pojo.User;
import com.atgao.mall.result.ResponseResult;
import com.atgao.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     */
    @PostMapping("register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

    /**
     * 登录
     */
    @PostMapping("login")
    public ResponseResult login(@RequestBody String name, String password){
        return userService.login(name, password);
    }
}
