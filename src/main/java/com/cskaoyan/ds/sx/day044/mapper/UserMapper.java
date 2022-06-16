package com.cskaoyan.ds.sx.day044.mapper;

import com.cskaoyan.ds.sx.day044.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserById(@Param("id") Integer id, @Param("password") String password);
    int insertUser(@Param("id")Integer id,@Param("password") String password);
    int modifytUserById(@Param("password")String password ,@Param("id")Integer id);
    int deleteUserById(@Param("id")Integer id,@Param("password") String password);
}
