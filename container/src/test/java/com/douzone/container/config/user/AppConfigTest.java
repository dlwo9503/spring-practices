package com.douzone.container.config.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.user.User;

public class AppConfigTest {
	// Java Config01
	// 직접 자바 클래스를 전달
	// 설정 클래스에 @Configuration이 필요 없다.
	@Test
	public void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);

		User user = ac.getBean(User.class);
		
		assertNotNull(user);
	}

	// Java Config02
	// 자바 설정 클래스가 있는 Base Package를 전달
	// 설정 클래스에 @Configuration이 반드시 필요하다.
	@Test
	public void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.douzone.container.config.user");

		User user = ac.getBean(User.class);
	}
}
