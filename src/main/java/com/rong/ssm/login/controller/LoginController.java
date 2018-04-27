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

@Controller // ע��Ϊ������
@RequestMapping(value = "/")
// �ػ����/login������
public class LoginController {
	@Autowired LoginService loginService; //ע��service��
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String get() {
		// ��������һ��ҳ��
		return "login";// ����ָ��login.jspҳ��
	}

	@RequestMapping(value = "/login_index",method = RequestMethod.POST)
	public String post(Model model,UserDTO user) {
	    //���������û��ĵ�½���� 
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
		    return "index"; //��½�ɹ�����ת��login_success.jspҳ��
		} else{
		    return "login";// ����ָ��login.jspҳ��
		}
	}
	@RequestMapping(value = "/seveUser")
	public String seveUser(Model model,UserDTO user) {
	    //���������û��ĵ�½���� 
	    if (null!=user&&user.toString()!=""&&null!=user.getUserCode()&&!"".equals(user.getUserCode())){ 
	    	Integer login_success=loginService.seveUser(user);
	    	List<UserDTO> userDTOList=new ArrayList<UserDTO>();
	    	Map<String,Object> map=new HashMap<String,Object>();
	    	//map.put("userCode", "admin");
	    	userDTOList=loginService.queryUserList(map);
	    	model.addAttribute("user",user);
	    	model.addAttribute("userDTOList",userDTOList);
	    	return "login_success";//�ɹ�����ת��login_success.jspҳ��
		} else{
			return "login_success";//�ɹ�����ת��login_success.jspҳ��
		}
	}
	
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(Model model, String userCode) {
	    //���������û��ĵ�½���� 
		List<UserDTO> userDTOList=new ArrayList<UserDTO>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userCode",userCode);
		loginService.deleteUser(map);
		Map<String,Object> map2=new HashMap<String,Object>();
		userDTOList=loginService.queryUserList(map2);
		model.addAttribute("userDTOList",userDTOList);
	    return "login_success";//�ɹ�����ת��login_success.jspҳ��
	}
}

