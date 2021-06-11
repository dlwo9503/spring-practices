package com.douzone.container.config.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning) // 복습!
//		testBeanFactory01();
		// XML Bean Configuration(Explicit Configuration : 명시적인 설정) // 복습!
//		testBeanFactory02();
		// XML Auto Configuration(Annotation Scanning) // 복습!
//		testApplicationContext01();
		// XML Bean Configuration(Explicit Configuration : 명시적인 설정) // 복습!
		testApplicationContext02();
	}

	// XML Bean Configuration(Explicit Configuration : 명시적인 설정) // 복습!
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext02.xml");
		
		// id로 Bean 가져오기
		User user = (User)ac.getBean("user");
		System.out.println(user);
		
		// name으로 Bean 가져오기
		user = (User)ac.getBean("usr");
		System.out.println(user);
		
		// type으로 Bean 가져오기
		// 같은 타입의 Bean이 2개 이상 있는 경우 type으로 가져오면 Error!!
		// 1. type + id
		// 2. type + name
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		// 2개 파라미터 생성자로 생성된 Bean 가져오기1
		user = ac.getBean("user3", User.class);
		System.out.println(user);
		
		// 2개 파라미터 생성자로 생성된 Bean 가져오기2
		user = ac.getBean("user4", User.class);
		System.out.println(user);
		
		// setter를 사용한 Bean 가져오기1
		user = ac.getBean("user5", User.class);
		System.out.println(user);
		
		// setter를 사용한 Bean 가져오기2(DI)
		user = ac.getBean("user6", User.class);
		System.out.println(user);
		
		// setter를 사용한 Bean 가져오기3(List Property)
		user = ac.getBean("user7", User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)ac).close();
	}

	// XML Auto Configuration(Annotation Scanning) // 복습!
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext01.xml");
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean id 가 자동으로 설정됨
		user1 = (User1)ac.getBean("user1");
		System.out.println(user1.getName());
		
		// 자원정리
		((ConfigurableApplicationContext)ac).close();
	}

	// XML Auto Configuration(Annotation Scanning) // 복습!
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean id 가 자동으로 설정됨
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}

	// XML Bean Configuration(Explicit Configuration : 명시적인 설정) // 복습!
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean id 가 자동으로 설정되지 않음
		// 명시적으로 설정해야 함.
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
	
}
