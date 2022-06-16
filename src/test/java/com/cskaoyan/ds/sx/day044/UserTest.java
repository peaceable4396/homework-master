package com.cskaoyan.ds.sx.day044;

import com.cskaoyan.ds.sx.day044.Utils.MyBatisUtils;
import com.cskaoyan.ds.sx.day044.bean.User;
import com.cskaoyan.ds.sx.day044.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author sx
 * @since 2022/06/09 22:50
 */

public class UserTest {

    static SqlSession sqlSession;
    static UserMapper userMapper;
    static Scanner sc = new Scanner(System.in);


    @BeforeClass
    public static void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testSelectUserById(){
        System.out.println("请输入账号");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("请输入密码");
        String password = sc.nextLine();
        User user =  userMapper.selectUserById(id,password);
        if (user != null){
            System.out.println(user);
        }else {
            System.out.println("输入有误");
        }


    }
    @Test
    public void testDeletUserById(){
        System.out.println("请输入账号");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("请输入密码");
        String password = sc.nextLine();
        int i = userMapper.deleteUserById(id, password);
        if (i != 0){
            System.out.println(i);
        }else {
            System.out.println("输入有误");
        }
    }
    @Test
    public void testInsertUser(){
        System.out.println("请输入密码");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        int insert = userMapper.insertUser(null, password);
        if (insert != 0){
            System.out.println(insert);
        }else {
            System.out.println("输入有误");
        }
    }
    @Test
    public void testUpDateUserById(){
        System.out.println("请输入账号");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("请输入密码");
        String password = sc.nextLine();
        int update = userMapper.modifytUserById(password, id);
        if (update != 0){
            System.out.println(update);
        }else {
            System.out.println("输入有误");
        }
    }
}
