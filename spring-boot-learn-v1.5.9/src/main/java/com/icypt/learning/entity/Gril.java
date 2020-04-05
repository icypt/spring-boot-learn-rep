package com.icypt.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * platform：admin
 * Author：guojun.chen
 * createTime： 2018/5/17 20:15
 * version：1.0
 * description：
 */
@Entity
public class Gril implements Serializable{

    private Integer id;
    private String name;
    private Integer age;
    private String cupSize;

    public Gril() {}

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value = 18, message = "未成年少女不能入内")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    @Override
    public String toString() {
        return "Gril{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
