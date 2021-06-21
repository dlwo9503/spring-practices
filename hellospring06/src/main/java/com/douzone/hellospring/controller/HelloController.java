package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 코드는 아니고 그냥 표시를 해놓은것
public class HelloController {
	
	@RequestMapping("/hello") // 어노테이션 지정
	public String hello() {
//		return "/WEB-INF/views/hello.jsp";
		return "hello";
	}
	
	@RequestMapping("/hello2") // 어노테이션 지정
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
	@RequestMapping("/hello3") // 어노테이션 지정
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
	@RequestMapping("/hello4") // 어노테이션 지정
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello4.jsp";
	}
	
}