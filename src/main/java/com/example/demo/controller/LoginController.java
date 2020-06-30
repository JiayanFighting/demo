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
	public void testAuto() throws IOException {
		System.out.println("/auto");
		// 创建命令集合
		List<String> commandList = new ArrayList<String>();
		commandList.add("touch 111.txt");
//		commandList.add("/c");  // 执行结束后关闭
//		commandList.add("echo");
//		commandList.add("hello");
//		commandList.add("cmd");
		// ProcessBuilder是一个用于创建操作系统进程的类，它的start()方法用于启动一个进行
		ProcessBuilder processBuilder = new ProcessBuilder(commandList);
		// 启动进程
		Process process = processBuilder.start();
		// 解析输出
		String result = convertStreamToStr(process.getInputStream());
		System.out.println(result);
	}

	public String convertStreamToStr(InputStream is) throws IOException {
		if (is != null) {
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

}
