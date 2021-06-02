package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") // 어노테이션 지정
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
}