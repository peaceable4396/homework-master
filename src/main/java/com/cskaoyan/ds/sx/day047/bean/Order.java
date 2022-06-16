package com.cskaoyan.ds.sx.day047.bean;

import lombok.Data;

import java.util.List;

/**
 * @author sx
 * @since 2022/06/13 21:22
 */
@Data
public class Order {
    private Integer orderId;
    private String orderMaker;
    List<Good> goodList;
}
