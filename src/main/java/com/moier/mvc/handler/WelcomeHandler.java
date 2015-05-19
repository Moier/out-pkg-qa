package com.moier.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moier.mvc.service.ISqliteService;

@Controller
@RequestMapping("welcome")
public class WelcomeHandler {
	@Autowired
	private ISqliteService sqlite ;
	
	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello(String username){
		try {
			
			sqlite.saveUserInfo(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hello world";
	}
	
	@RequestMapping("query")
	@ResponseBody
	public String query(){
		try {
			this.sqlite.query();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hh";
	}

}
