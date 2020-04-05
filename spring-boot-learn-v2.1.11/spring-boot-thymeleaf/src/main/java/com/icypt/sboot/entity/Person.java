package com.icypt.sboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PlatForm： 冰点IT
 * projectName: 个人博客
 * Author：icypt
 * CreateTime： 2020/2/25 17:56
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private String desc;

}
