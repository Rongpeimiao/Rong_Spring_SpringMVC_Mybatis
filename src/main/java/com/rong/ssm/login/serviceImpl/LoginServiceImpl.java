package com.rong.ssm.login.serviceImpl;

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
}

