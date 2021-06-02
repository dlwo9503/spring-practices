package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RequestMapping
 * 클래스 + 핸들러(메소드)
 * @author jaes
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
//		return "join"; // 이렇게 join만 해주고 viewResolver에서 앞뒤로 주소값을 설정해서 덧붙여줄 수 있음
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST) // 받아와서 보여주는거
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/"; // ResponseBody로 화면에 바로 나타내지 않고 redirect 해줌 (redirect/url(내가 써준거만 써줌))
	}
}
