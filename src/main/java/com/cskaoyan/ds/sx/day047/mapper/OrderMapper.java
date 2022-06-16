package com.cskaoyan.ds.sx.day047.mapper;

import com.cskaoyan.ds.sx.day047.bean.Good;
import com.cskaoyan.ds.sx.day047.bean.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    Order selectGoodsListById(@Param("id") int id);

    Good selectGoodByOrderId(@Param("id") int id);

    Order selectGoodsListUsingCrossQuery(@Param("id") int id);
}
