package com.atgao.mall.service;

import com.atgao.mall.pojo.User;
import com.atgao.mall.result.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserService extends IService<User> {
    /**
     * 注册
     * @param user
     * @return
     */
    ResponseResult register(User user);

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    ResponseResult login(String name, String password);
}
