package com.wip.service.log.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.service.log.LogService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogServiceImplTest {
	@Autowired
	private LogService logService;
	
	@Test
	public void addLog() {
		logService.addLog("123", "123", "123", 1);
	}
	
	@Test
	public void getLogs() {
		logService.getLogs(1, 15);
	}
}
