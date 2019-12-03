package com.study.mybatis.mybatisbase;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String username;
    String password;
    String email;
    String phone;
    String address;

    public User(String username,String password,String email,String phone,String address){
        this.username=username;
        this.password=password;
        this.email=email;
        this.phone=phone;
        this.address=address;
    }
}
