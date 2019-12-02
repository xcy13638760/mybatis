package com.study.mybatis.mybatisbase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisBaseApplicationTests {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void creatSqlSessionFactory() throws IOException {
        String resource = "SqlMapConfig.xml";
        // 读取SqlMapConfig文件
        InputStream in = Resources.getResourceAsStream(resource);
        //创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void testFindUserById(){
        SqlSession sqlSession =null;
        try {
            //  获取SqlSeesion
            sqlSession = sqlSessionFactory.openSession();
            // 查询
            User user = sqlSession.selectOne("test.findUserById",1);
            // 输出
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession =null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            User user = new User("小小", "111", "1@com", "123", "sasas");
            int count =sqlSession.insert("test.addUser", user);
            System.out.println(count);
            sqlSession.commit();
            System.out.println(user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }

    }
    @Test
    public void testDeleteUser(){
        SqlSession sqlSession =null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            int count =sqlSession.delete("test.deleteUserById", 13);
            System.out.println(count);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
    }
    @Test
    public void testUpdateUser(){
        SqlSession sqlSession =null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            User u =new User("修改","1234","test@","121212","");
            u.setId(1);
            int count =sqlSession.update("test.updateUser", u);
            System.out.println(count);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
    }
}
