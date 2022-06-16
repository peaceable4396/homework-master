package com.cskaoyan.ds.sx.day046.mapper;

import com.cskaoyan.ds.sx.day046.Utils.MyBatisUtils;
import com.cskaoyan.ds.sx.day046.bean.User;
import com.cskaoyan.ds.sx.day046.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sx
 * @since 2022/06/11 15:14
 */

public class UserTest {

    static SqlSession sqlSession;
    static UserMapper userMapper;
    static Scanner sc;

    @BeforeClass
    public static void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        sc = new Scanner(System.in);
    }

    @Test
    public void testInsertUsers(){
        User user1 = new User();
        user1.setName("aa");
        user1.setGender("male");
        User user2 = new User();
        user2.setName("bb");
        user2.setGender("female");
        List<User> users = new LinkedList<>();
        users.add(user1);
        users.add(user2);
        int i = userMapper.insertUsers(users);
        System.out.println(i);
    }
    @Test
    public void testInsertUsers2(){
        User user1 = new User();
        user1.setName("aa");
        user1.setGender("male");
        User user2 = new User();
        user2.setName("bb");
        user2.setGender("female");
        List<User> users = new LinkedList<>();
        users.add(user1);
        users.add(user2);
        int i = userMapper.insertUsers(users);
        System.out.println(i);
    }
    @Test
    public void testUpdateSelectiveUser(){
        User user1 = new User();
        user1.setId(1001);
        user1.setName("cc");

        int i = userMapper.updateSelectiveUser(user1);
        System.out.println(i);

    }
    @Test
    public void testSelectUserListByIds(){
        List<Integer> list= new LinkedList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<User> users = userMapper.selectUserListByIds(list);
        System.out.println(users);
    }
    @Test
    public void testSelectUserListByUser(){
        User user2 = new User();
        user2.setName("aa");
        List<User> users = userMapper.selectUserListByUser(user2);
        System.out.println(users);
    }
    @Test
    public void testInsertUser(){
        User user1 = new User();
        user1.setName("dd");
        user1.setGender("male");
        int i = userMapper.insertUser(user1);
        System.out.println(i);
        System.out.println(user1);
    }
    @Test
    public void testInsertUserUseGeneratedKeys(){
        User user1 = new User();
        user1.setName("dd");
        user1.setGender("male");
        int i = userMapper.insertUserUseGeneratedKeys(user1);
        System.out.println(i);
        System.out.println(user1);
    }
}
