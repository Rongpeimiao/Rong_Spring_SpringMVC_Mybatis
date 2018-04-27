package com.rong.ssm.login.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.rong.ssm.login.entity.UserDTO;
/**
 * 
 * @author rong
 * dao²ã
 */

@Repository
public interface UserDao {
	 UserDTO selectUser(@Param("userCode")String userName,@Param("password")String password); 
	 int seveUser(@Param("user")UserDTO user);
	 List<UserDTO>  queryUserList(@Param("paramMap")Map<String, Object> paramMap);
	 void deleteUser(@Param("paramMap")Map<String, Object> paramMap);
	
}
