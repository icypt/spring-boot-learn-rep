package com.icypt.sboot.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * PlatForm： 冰点IT
 * projectName: SpringBoot 学习
 * Author：icypt
 * CreateTime： 2020/4/4 11:08
 * Version：2.0
 * Description：如果是判断空字符串用@NotBlank,如果是判断空对象用@NotNull，否则校验不生效
 * URL: www.icypt.com
 */
@Setter
@Getter
public class UserInfo implements Serializable {
    private String userName;
    private String password;
    private String token;
}
