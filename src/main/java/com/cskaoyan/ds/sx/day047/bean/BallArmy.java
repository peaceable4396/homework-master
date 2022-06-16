package com.cskaoyan.ds.sx.day047.bean;

import lombok.Data;

import java.util.List;

/**
 * @author sx
 * @since 2022/06/13 20:14
 */
@Data
public class BallArmy {
    private Integer id;
    private String armyName;
    List<Player> playerList;
}
