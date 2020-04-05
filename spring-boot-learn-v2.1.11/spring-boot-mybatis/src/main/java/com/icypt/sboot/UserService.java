package com.icypt.sboot;

import com.icypt.sboot.entity.User;
import com.icypt.sboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PlatForm： 冰点IT
 * projectName: 个人博客
 * Author：icypt
 * CreateTime： 2020/3/30 21:26
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User findById(Long userId) {
        /**
         * 验证一级缓存，在一次会话中，只执行了一次真实查询
         */
        userMapper.findById(userId);
        userMapper.findById(userId);
        return userMapper.findById(userId);
    }
}
