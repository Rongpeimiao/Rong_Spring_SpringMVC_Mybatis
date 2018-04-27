package com.rong.ssm.login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rong.ssm.login.entity.UserDTO;
import com.rong.ssm.login.service.LoginService;

@Controller // 注解为控制器
@RequestMapping(value = "/")
// 截获带有/login的请求
public class LoginController {
	@Autowired LoginService loginService; //注入service层
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String get() {
		// 用来返回一个页面
		return "login";// 返回指向login.jsp页面
	}

	@RequestMapping(value = "/login_index",method = RequestMethod.POST)
	public String post(Model model,UserDTO user) {
	    //用来处理用户的登陆请求 
	    if (loginService.login(user.getUserCode(), user.getPassword())==1){ 
	    	List<UserDTO> userDTOList=new ArrayList<UserDTO>();
	    	Map<String,Object> map=new HashMap<String,Object>();
	    	userDTOList=loginService.queryUserList(map);
	    	for(int i=0;i<userDTOList.size();i++){
	    		System.out.println(userDTOList.get(i).getUserCode());
	    	}
	    	System.out.println(userDTOList.size());
	    	model.addAttribute("user",user);
	    	model.addAttribute("userDTOList",userDTOList);
		    return "index"; //登陆成功，跳转到login_success.jsp页面
		} else{
		    return "login";// 返回指向login.jsp页面
		}
	}
	@RequestMapping(value = "/seveUser")
	public String seveUser(Model model,UserDTO user) {
	    //用来处理用户的登陆请求 
	    if (null!=user&&user.toString()!=""&&null!=user.getUserCode()&&!"".equals(user.getUserCode())){ 
	    	Integer login_success=loginService.seveUser(user);
	    	List<UserDTO> userDTOList=new ArrayList<UserDTO>();
	    	Map<String,Object> map=new HashMap<String,Object>();
	    	//map.put("userCode", "admin");
	    	userDTOList=loginService.queryUserList(map);
	    	model.addAttribute("user",user);
	    	model.addAttribute("userDTOList",userDTOList);
	    	return "login_success";//成功，跳转到login_success.jsp页面
		} else{
			return "login_success";//成功，跳转到login_success.jsp页面
		}
	}
	
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(Model model, String userCode) {
	    //用来处理用户的登陆请求 
		List<UserDTO> userDTOList=new ArrayList<UserDTO>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userCode",userCode);
		loginService.deleteUser(map);
		Map<String,Object> map2=new HashMap<String,Object>();
		userDTOList=loginService.queryUserList(map2);
		model.addAttribute("userDTOList",userDTOList);
	    return "login_success";//成功，跳转到login_success.jsp页面
	}
}

