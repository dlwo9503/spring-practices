package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) { // 이렇게 하면 n이라는 이름의 변수로 받아도 name로 사용 가능
		/**
		 * 만일 n이라는 이름의 파라미터가 없는 경우
		 * 400 Bad Request 에러가 발생한다.
		 */
		System.out.println(name);
		return "UserController.update()";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value="n", required=true, defaultValue="") String name, // value는 디폴트 값이여서 하나만 쓸때는 생략가능
			@RequestParam(value="a", required=true, defaultValue="0") int age) {
		/**
		 * required=true가 디폴트 값, false로 하면 n의 값이 주어지지 않아도 null 값을 넣어줌
		 * required=true로 해놓고 n의 값이 안들어 왔을때 defaultValue="" 를 추가해주면 n의 값의 디폴트값을 지정해놓을 수 있음 (String 타입)
		 */
		System.out.println("---" + name + "---" + age);
		return "UserController.update2()";
	}
}
