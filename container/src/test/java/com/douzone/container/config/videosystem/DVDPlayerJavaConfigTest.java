package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

//JUnit 확장하는 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
//Spring Bean 메타 설정 파일의 위치를 지정
@ContextConfiguration(classes=DVDPlayerConfig.class)
public class DVDPlayerJavaConfigTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DigitalVideoDisc dvd;
	
	// 같은 타입의 빈이 2개 이상 존재하는 경우 1 : 
	// 설정 클래스의 빈생성 메소드 이름
	// @Qualifier("dvdPlayer03")
	
	// 같은 타입의 빈이 2개 이상 존재하는 경우 2 : 
	// 설정 클래스의 빈생성 메소드의 @Bean의 name속성
	@Qualifier("player04")
	@Autowired
	private DVDPlayer player;
	
	@Test
	public void testDVDNotNull() {
		assertNotNull(dvd);
	}
	
	@Test
	public void testPlayerNotNull() {
		assertNotNull(player);
	}
	
	@Test
	public void testPlayer() {
		player.play();
		assertEquals("playing Movie MARVEL's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}
