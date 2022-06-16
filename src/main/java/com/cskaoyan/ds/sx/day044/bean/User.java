package com.cskaoyan.ds.sx.day044.bean;

/**
 * @author sx
 * @since 2022/06/09 20:18
 */

public class User {
    private Integer id;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", passWord='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }
}
