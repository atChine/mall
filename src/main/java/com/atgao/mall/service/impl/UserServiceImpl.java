package com.atgao.mall.service.impl;

import com.atgao.mall.enums.AppHttpCodeEnum;
import com.atgao.mall.result.ResponseResult;
import com.atgao.mall.vo.LoginVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atgao.mall.pojo.User;
import com.atgao.mall.service.UserService;
import com.atgao.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.util.List;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public ResponseResult register(User user) {
        //昵称和邮箱不能重复
        String username = user.getUsername();
        String email = user.getEmail();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getEmail,email)
                    .eq(User::getUsername,username);
        int count = count(queryWrapper);
        if (count > 0){
            return ResponseResult.fail(2,"用户已存在");
        }
        //将密码加密，存入数据库
        DigestUtils.md5DigestAsHex(user.getPassword().getBytes(Charset.forName("utf-8")));
        int insert = userMapper.insert(user);
        if (insert == 0){
            throw new RuntimeException("注册失败");
        }
        return ResponseResult.success(0,"校验成功");
    }

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public ResponseResult login(String name, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes(Charset.forName("utf-8")));
        queryWrapper.eq(User::getUsername, name)
                .eq(User::getPassword,passwordMd5);
        int count = count(queryWrapper);
        if (count != 1){
            return ResponseResult.fail(1,"密码错误");
        }

        return null;
    }
}




