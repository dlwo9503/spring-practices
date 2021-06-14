package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.config.videosystem.mixing.DVDPlayerConfig;
import com.douzone.container.videosystem.DVDPlayer;

//JUnit 확장하는 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
//Spring Bean 메타 설정 파일의 위치를 지정
@ContextConfiguration(classes=DVDPlayerConfig.class)
public class DVDPlayerMixingConfig01Test {
	@Autowired
	private DVDPlayer player;
	
	@Test
	public void testPlayer() {
		assertNotNull(player);
	}
}
