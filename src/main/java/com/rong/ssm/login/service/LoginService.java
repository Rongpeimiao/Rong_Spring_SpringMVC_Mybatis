package com.rong.ssm.login.service;

import java.util.List;
import java.util.Map;


import com.rong.ssm.login.entity.UserDTO;

public interface LoginService {
	public int login(String userCode,String password);
	public int seveUser(UserDTO user);
	public List<UserDTO> queryUserList(Map<String, Object> map);
	public void deleteUser(Map<String, Object> map);

}
