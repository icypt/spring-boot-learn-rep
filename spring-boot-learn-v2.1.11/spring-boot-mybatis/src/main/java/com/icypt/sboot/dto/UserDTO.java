package com.icypt.sboot.dto;

import com.icypt.sboot.entity.Blog;
import com.icypt.sboot.entity.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * PlatForm： 冰点IT
 * projectName: 个人博客
 * Author：icypt
 * CreateTime： 2020/3/29 12:26
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */
@Setter
@Getter
public class UserDTO{
    private Long userId;
    private String userName;
    private Company company;
    private List<Blog> blogList;
}
