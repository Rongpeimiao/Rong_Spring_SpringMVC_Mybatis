package com.rong.ssm.login.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rong.ssm.login.dao.UserDao;
import com.rong.ssm.login.entity.UserDTO;
import com.rong.ssm.login.service.LoginService;
@Service 
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public int login(String userCode,String password){ 
		 UserDTO user = userDao.selectUser(userCode,password);
	     return user==null?0:1;
	}

	@Override
	public int seveUser(UserDTO user) {
		int i= userDao.seveUser(user);
	     return i==0?0:1;
	}

	@Override
	public List<UserDTO> queryUserList(Map<String, Object> map) {
		List<UserDTO> userlist=new ArrayList<UserDTO>();
		userlist=userDao.queryUserList(map);
		return userlist;
	}

	@Override
	public void deleteUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		userDao.deleteUser(map);
	}
}

