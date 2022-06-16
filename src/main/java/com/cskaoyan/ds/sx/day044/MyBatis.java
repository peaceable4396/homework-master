package com.cskaoyan.ds.sx.day044;

import com.cskaoyan.ds.sx.day044.Utils.MyBatisUtils;
import com.cskaoyan.ds.sx.day044.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;

import java.util.Scanner;

/**
 * @author sx
 * @since 2022/06/09 22:59
 */

public class MyBatis {
    static SqlSession sqlSession;
    @BeforeClass
    public static void init() {
        sqlSession = MyBatisUtils.getSqlSession();
    }

    static User selectUserByPutIn(int id){
        System.out.println("请输入密码");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        User userIn = new User();
        userIn.setId(id);
        userIn.setPassWord(password);
        User user =  sqlSession.selectOne("user-day044.selectUserById",userIn);
        if (user!= null){
            return user;
        }else return null;
    }
    static void deletUserById(int id){
        if (selectUserByPutIn(id) == null){
            return;
        }
        int delete = sqlSession.delete("user-day044.selectUserById", id);
        System.out.println(delete);
    }
    static void insertUser(){
        System.out.println("请输入密码");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        int insert = sqlSession.insert("user-day044.insertUser", password);
        System.out.println(insert);
    }
    static void upDateUserById(int id){
        if (selectUserByPutIn(id) == null){
            return;
        }
        System.out.println("请输入密码");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        User userIn = new User();
        userIn.setId(id);
        userIn.setPassWord(password);
        int update = sqlSession.update("user-day044.selectUserById", userIn);
        System.out.println(update);
    }

    public static void main(String[] args) {
        insertUser();
    }
}
