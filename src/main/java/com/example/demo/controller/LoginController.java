package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.UserService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String welcomeLogin(){
		return "login";
	}

	@PostMapping("/login")
	@ResponseBody
	String ajaxLogin(String username, String password) {
		System.out.println("username="+username+" password="+password);
		int code = userService.login(username,password);
		System.out.println("code = "+code);
		JSONObject result = new JSONObject() ;
		result.put("code",code);
		try {
			result.put("msg","登录成功！");
		} catch (Exception e) {
			result.put("msg","用户或密码错误！");
		}
		return result.toJSONString();
	}


	@RequestMapping("/auto")
	public void testAuto() throws IOException, InterruptedException {
		String bashCommand = "/root/project/demo/demo.sh";
		Runtime runtime = Runtime.getRuntime();
		Process pro = runtime.exec(bashCommand);
		int status = pro.waitFor();
		if (status != 0){
			System.out.println("restart go server error");
			return;
		}
		System.out.println("restart go server success");
		System.out.println("restart go server success3");
	}

}
