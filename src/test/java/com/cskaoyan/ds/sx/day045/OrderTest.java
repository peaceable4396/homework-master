package com.cskaoyan.ds.sx.day045;

import com.cskaoyan.ds.sx.day044.Utils.MyBatisUtils;
import com.cskaoyan.ds.sx.day045.bean.Order;
import com.cskaoyan.ds.sx.day045.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

/**
 * @author sx
 * @since 2022/06/10 20:19
 */

public class OrderTest {

    static SqlSession sqlSession;
    static OrderMapper orderMapper;
    static Scanner sc;

    @BeforeClass
    public static void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        sc = new Scanner(System.in);
    }
    @Test
    public void testSelectIdByOrderName(){
        System.out.println("请输入订单名");
        String orderName = sc.nextLine();
        int i = orderMapper.selectIdByOrderName(orderName);
        System.out.println(i);
    }
    @Test
    public void testSelectIdList(){
        List<Integer> integers = orderMapper.selectIdList();
        System.out.println(integers);
    }
    @Test
    public void testSelectIdArray(){
        Integer[] integers = orderMapper.selectIdArray();
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    @Test
    public void testSelectOrderById(){
        System.out.println("请输入订单id");
        Integer id = sc.nextInt();
        Order order = orderMapper.selectOrderById(id);
        System.out.println(order);
    }
    @Test
    public void testSelectOrderList(){
        List<Order> orders = orderMapper.selectOrderList();
        System.out.println(orders);
    }
    @Test
    public void testSelectOrderArray(){
        Order[] orders = orderMapper.selectOrderArray();
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    @Test
    public void testSelectOrderListByColumnName(){
        List<Order> orders = orderMapper.selectOrderListByColumnName(1004,"'id'");
        System.out.println(orders);
    }
}
