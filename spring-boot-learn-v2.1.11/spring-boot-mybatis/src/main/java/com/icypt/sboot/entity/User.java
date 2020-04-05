package com.icypt.sboot.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 5552718012736544254L;
    private Long userId;
    private String userName;
    private Long companyId;
}