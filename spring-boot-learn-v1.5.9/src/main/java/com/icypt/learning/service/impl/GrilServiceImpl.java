package com.icypt.learning.service.impl;

import com.icypt.learning.SystemException;
import com.icypt.learning.entity.Gril;
import com.icypt.learning.enums.ExceptionEnum;
import com.icypt.learning.repository.GrilRepository;
import com.icypt.learning.service.GrilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/17 20:23
 * version：1.0
 * description：
 */
@Service
public class GrilServiceImpl implements GrilService{
    @Autowired
    private GrilRepository repository;

    @Override
    public List<Gril> findAllGrils() {
        return repository.findAll();
    }

    @Override
    public Gril findGrilById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Gril updateGril(Gril gril) {
        return repository.save(gril);
    }

    @Override
    public void deleteGrilById(Integer id) {
        repository.delete(id);
    }

    @Override
    public Gril insertGril(Gril gril) {
        return repository.save(gril);
    }

    @Transactional
    @Override
    public void insertGrilTwo() {
        Gril gril1 = new Gril();
        gril1.setCupSize("H");
        gril1.setAge(12);
        gril1.setName("童颜");
        repository.save(gril1);
        Gril gril2 = new Gril();
        gril2.setCupSize("F");
        gril2.setAge(1);
        gril2.setName("海豚巨乳");
        repository.save(gril2);
    }

    @Override
    public Integer getAge(Integer id) {
        Gril gril = repository.findOne(id);
        int age = gril.getAge();
        if(age < 16) {
            throw new SystemException(ExceptionEnum.WEI_CHENG_NIAN.getCode(),
                    ExceptionEnum.WEI_CHENG_NIAN.getMessage());
        } else {
            return age;
        }
    }
}
