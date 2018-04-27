package com.rong.ssm.login.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author rong
 * dao²ã
 */
import com.rong.ssm.login.entity.UserDTO;
@Repository
public interface UserDao {
	 UserDTO selectUser(@Param("userCode")String userName,@Param("password")String password); 
}
