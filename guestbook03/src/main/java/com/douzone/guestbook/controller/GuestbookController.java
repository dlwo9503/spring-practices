package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value = "/deleteform/{no}", method=RequestMethod.GET)
	public String deleteform(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no); // key, value 값을 view에 전달함
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value = "/delete/{no}", method=RequestMethod.POST)
	public String delete(@PathVariable("no") Long no, GuestbookVo vo) {
		GuestbookVo vo1 = guestbookRepository.findAll2(no);
		if(vo1.getPassword().equals(vo.getPassword())){
			guestbookRepository.delete(vo1);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
}
