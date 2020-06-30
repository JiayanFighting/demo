package com.example.demo.controller;

import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping()
	String SysUser(){
	    return "blog/sysUser/sysUser";
	}

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}



}
