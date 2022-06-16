package com.cskaoyan.ds.sx.day047.mapper;

import com.cskaoyan.ds.sx.day047.bean.BallArmy;
import com.cskaoyan.ds.sx.day047.bean.Player;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArmyMapper {
    BallArmy selectPlayerListById(@Param("id") int id);

    Player selectPlayByArmyId(@Param("armyId") int armyId);

    BallArmy selectPlayerListUsingCrossQuery(@Param("id") int id);
}
