package com.cskaoyan.ds.sx.day046.mapper;

import com.cskaoyan.ds.sx.day046.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insertUsers(List<User> users);

    int insertUsers2(@Param("users") List<User> users);

    int updateSelectiveUser(@Param("user") User user);

    List<User> selectUserListByIds(List<Integer> ids);

    List<User> selectUserListByUser(@Param("user") User user);

    int insertUser(@Param("user") User user);

    int insertUserUseGeneratedKeys(@Param("user") User user);
}
