package com.study.mybatis.mybatisspringboot.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.mybatis.mybatisspringboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {

      User user=  userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void test5(){
        PageHelper.startPage(1,5); //访问第1页，每页显示5条
        List<User> list = userMapper.selectAll();
        for (User s : list) {
            System.out.println(s);
        }

        long count = ((Page) list).getTotal(); //获取总条数
        System.out.println(count);
        PageHelper.clearPage();
        List<User> list2 = userMapper.selectAll();
        for (User s : list2) {
            System.out.println(s);
        }
    }
}