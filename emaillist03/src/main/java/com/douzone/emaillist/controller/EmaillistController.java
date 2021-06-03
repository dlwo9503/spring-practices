package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
//		public String add(HttpServletRequest request, EmaillistVo vo) { // 이렇게 안해도 스프링에서 처리할 수 있음
//			request.setCharacterEncoding("utf-8"); // HttpServletRequest request 추가해주고 사용, 한글 처리
		
		emaillistRepository.insert(vo);
		return "redirect:/"; // == return "redirect:/emaillist03";
	}
}
