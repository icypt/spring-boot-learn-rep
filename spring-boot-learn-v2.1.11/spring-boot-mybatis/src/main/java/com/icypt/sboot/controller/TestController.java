package com.icypt.sboot.controller;

import com.icypt.sboot.UserService;
import com.icypt.sboot.entity.User;
import com.icypt.sboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PlatForm： 冰点IT
 * projectName: 个人博客
 * Author：icypt
 * CreateTime： 2020/3/23 22:41
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public Object insert(User user) {
        userMapper.insert(user);
        return user.getUserId();
    }

    /**
     * 批量插入用户数据
     * @param userList
     * @return
     */
    @RequestMapping("/batchInsert")
    public Object batchInsert(@RequestBody List<User> userList) {
        userMapper.batchInsert(userList);
        return "ok";
    }

    /**
     * 删除用户数据
     * @param userId
     * @return
     */
    @GetMapping("/deleteById/{userId}")
    public Object deleteById(@PathVariable Long userId) {
        userMapper.deleteById(userId);
        return "ok";
    }

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    @PostMapping("/updateById")
    public Object updateById(User user) {
        userMapper.updateById(user);
        return "ok";
    }

    /**
     * 查询用户数据
     * @param userId
     * @return
     */
    @GetMapping("/findById/{userId}")
    public Object findById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    /**
     * 根据用户id数组查询用户列表
     * @param ids
     * @return
     */
    @RequestMapping("/findByIds")
    public Object findByIds(Long[] ids) {
        return userMapper.findByIds(ids);
    }

    /**
     * 获取用户文章信息
     * @param userId
     * @return
     */
    @RequestMapping("/getUserBlogInfo/{userId}")
    public Object getUserBlogInfo(@PathVariable Long userId) {
        return userMapper.getUserBlogInfo(userId);
    }

    /**
     * 获取用户公司信息
     * @param userId
     * @return
     */
    @RequestMapping("/getUserCompanyInfo/{userId}")
    public Object getUserCompanyInfo(@PathVariable Long userId) {
        return userMapper.getUserCompanyInfo(userId);
    }
}
