package com.icypt.sboot.entity;

import lombok.Builder;
import lombok.Data;

/**
 * PlatForm： 冰点IT
 * projectName: 个人博客
 * Author：icypt
 * CreateTime： 2020/3/29 12:10
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */
@Builder
@Data
public class Company {
    private Long companyId;
    private String companyName;
}
