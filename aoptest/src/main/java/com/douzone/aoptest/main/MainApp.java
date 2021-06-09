package com.douzone.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.aoptest.service.ProductService;
import com.douzone.aoptest.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml"); // xml을 이용해 ac를 하나 만들고
//		aspect도 ac안에 만들어짐
		ProductService ps = ac.getBean(ProductService.class); // ac안에 ps를 생성하고
		ProductVo vo = ps.find("TV"); // find라는 메소드로 TV를 검색해보아라 -> 검색해서 객체에 넣고
		System.out.println("[maen] " + vo); // 출력
		
		((AbstractApplicationContext)ac).close();
	}

}
