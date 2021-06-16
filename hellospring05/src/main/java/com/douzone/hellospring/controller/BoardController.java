package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping
 * 메소드 단독 매핑
 *
 */

@Controller
public class BoardController {

	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController:write";
	}
	
	@ResponseBody
	@RequestMapping("/board/view/{no}") // 변수는 {} 안에 넣어줌
	public String view(@PathVariable("no") Long boardNo) { // Path(/board/view) 에 있는 변수라는 뜻
		return "BoardController:view(" + boardNo + ")";
	}
	
}
