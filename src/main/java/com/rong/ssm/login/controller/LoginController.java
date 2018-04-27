package com.rong.ssm.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.rong.ssm.login.entity.UserDTO;
import com.rong.ssm.login.service.LoginService;

@Controller // ע��Ϊ������
@RequestMapping(value = "/login")
// �ػ����/login������
public class LoginController {
	@Autowired LoginService loginService; //ע��service��
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		// ��������һ��ҳ��
		return "login";// ����ָ��login.jspҳ��
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(UserDTO user) {
	    //���������û��ĵ�½���� 
	    if (loginService.login(user.getUserCode(), user.getPassword())==1){ 
		    return "login_success"; //��½�ɹ�����ת��login_success.jspҳ��
		} else{
		    return "login";// ����ָ��login.jspҳ��
		}
	}
	
}

