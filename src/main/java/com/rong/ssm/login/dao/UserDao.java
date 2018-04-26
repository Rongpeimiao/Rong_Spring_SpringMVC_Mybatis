package com.rong.ssm.login.dao;

import org.apache.ibatis.annotations.Param;

import com.rong.ssm.login.entity.UserDTO;

public interface UserDao {
	 UserDTO selectUser(@Param("userName")String userName,@Param("password")String password); 
}
