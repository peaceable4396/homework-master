package com.cskaoyan.ds.sx.day045.mapper;

import com.cskaoyan.ds.sx.day045.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    int selectIdByOrderName(String orderName);

    List<Integer> selectIdList();

    Integer[] selectIdArray();

    Order selectOrderById(Integer id);

    List<Order> selectOrderList();

    Order[] selectOrderArray();

    List<Order> selectOrderListByColumnName(@Param("id") Integer id, @Param("columnName") String columnName);


}
