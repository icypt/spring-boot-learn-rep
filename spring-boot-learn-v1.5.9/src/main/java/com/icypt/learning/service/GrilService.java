package com.icypt.learning.service;

import com.icypt.learning.entity.Gril;

import java.util.List;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/17 20:22
 * version：1.0
 * description：
 */
public interface GrilService {
    List<Gril> findAllGrils();

    Gril findGrilById(Integer id);

    Gril updateGril(Gril gril);

    void deleteGrilById(Integer id);

    Gril insertGril(Gril gril);

    void insertGrilTwo();

    Integer getAge(Integer id);
}
