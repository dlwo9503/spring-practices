package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * RequestMapping
 * 클래스(타입) 단독 매핑
 * @author jaes
 *
 */

@Controller
@RequestMapping("/guestbook/*") // 쓸때는 *에 list가 위치함
public class GuestbookController {
	@ResponseBody
	@RequestMapping // url을 붙이지 않음, 위에 붙임
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping // url을 붙이지 않음, 위에 붙임
	public String delete() {
		return "GuestbookController:delete";
	}
}
