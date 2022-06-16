package com.cskaoyan.ds.sx.day047;

import com.cskaoyan.ds.sx.day046.Utils.MyBatisUtils;
import com.cskaoyan.ds.sx.day047.bean.BallArmy;
import com.cskaoyan.ds.sx.day047.bean.Goods;
import com.cskaoyan.ds.sx.day047.bean.Order;
import com.cskaoyan.ds.sx.day047.mapper.ArmyMapper;
import com.cskaoyan.ds.sx.day047.mapper.GoodMapper;
import com.cskaoyan.ds.sx.day047.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author sx
 * @since 2022/06/13 20:38
 */

public class ArmyTest {

    static SqlSession sqlSession;
    static ArmyMapper armyMapper;
    static OrderMapper orderMapper;
    static GoodMapper goodMapper;
    static Scanner sc;

    @BeforeClass
    public static void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        armyMapper = sqlSession.getMapper(ArmyMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        goodMapper = sqlSession.getMapper(GoodMapper.class);
        sc = new Scanner(System.in);
    }

    @Test
    public void testSelectPlayerListById() {
        int i = sc.nextInt();
        BallArmy ballArmy = armyMapper.selectPlayerListById(i);
        System.out.println(ballArmy);
    }

    @Test
    public void testSelectPlayerListUsingCrossQuery() {
        int i = sc.nextInt();
        BallArmy ballArmy = armyMapper.selectPlayerListUsingCrossQuery(i);
        System.out.println(ballArmy);
    }

    @Test
    public void testSelectGoodsListById() {
        int i = sc.nextInt();
        Order order = orderMapper.selectGoodsListById(i);
        System.out.println(order);
    }

    @Test
    public void testSelectGoodsListUsingCrossQuery() {
        int i = sc.nextInt();
        Order order = orderMapper.selectGoodsListUsingCrossQuery(i);
        System.out.println(order);
    }

    @Test
    public void testSelectGoodsDetailById() {
        int i = sc.nextInt();
        Goods goods = goodMapper.selectGoodsDetailById(i);
        System.out.println(goods);
    }

    @Test
    public void testSelectGoodsUsingCrossQuery() {
        int i = sc.nextInt();
        Goods goods = goodMapper.selectGoodsUsingCrossQuery(i);
        System.out.println(goods);
    }
}
