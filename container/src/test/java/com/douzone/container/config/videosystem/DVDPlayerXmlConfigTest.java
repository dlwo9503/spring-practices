package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.videosystem.DigitalVideoDisc;

//JUnit 확장하는 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
//Spring Bean 메타 설정 파일의 위치를 지정
@ContextConfiguration(locations= {"classpath:/com/douzone/container/config/videosystem/DVDPlayerConfig.xml"})
public class DVDPlayerXmlConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	// @Autowired
	// 예외 발생
	// XML Bean 설정 시 id는 자동으로 부여되지 않는다
	// @Qualifier 사용 불가
	DigitalVideoDisc dvd1;
	
	@Autowired
	@Qualifier("ironMan")
	DigitalVideoDisc dvd2;
	
	@Ignore
	@Test
	public void testDVD1() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDVD2() {
		assertNotNull(dvd2);
	}
}
