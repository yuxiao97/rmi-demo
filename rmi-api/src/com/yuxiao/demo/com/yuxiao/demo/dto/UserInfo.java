package com.yuxiao.demo.com.yuxiao.demo.dto;

import java.io.Serializable;

/**
 * @author yuxiao
 * @date 2021-04-12 17:22
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 340313752352809088L;

    private int uid;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
