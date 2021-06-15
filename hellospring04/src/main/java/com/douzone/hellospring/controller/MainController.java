package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody // 화면에 나오도록 해주는것
	@RequestMapping({"", "/main"}) // {}안에는 여러개의 값이 들어올 수 있음
	public String main() {
		return "MainController:main()";
	}
}
