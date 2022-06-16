package com.cskaoyan.ds.sx.day047.bean;

import lombok.Data;

/**
 * @author sx
 * @since 2022/06/13 21:59
 */
@Data
public class Goods {
    private Integer goodId;
    private String goodName;
    private GoodsDetail goodsDetail;
}
