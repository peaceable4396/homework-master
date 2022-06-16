package com.cskaoyan.ds.sx.day047.mapper;

import com.cskaoyan.ds.sx.day047.bean.Good;
import com.cskaoyan.ds.sx.day047.bean.Goods;
import com.cskaoyan.ds.sx.day047.bean.GoodsDetail;
import org.apache.ibatis.annotations.Param;

public interface GoodMapper {
    Goods selectGoodsDetailById(@Param("id") int id);

    GoodsDetail selectGoodsDetailByGoodId(@Param("id") int id);

    Goods selectGoodsUsingCrossQuery(@Param("id") int id);
}
