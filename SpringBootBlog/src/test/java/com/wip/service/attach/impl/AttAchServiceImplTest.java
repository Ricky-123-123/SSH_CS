package com.wip.service.attach.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.wip.dto.AttAchDto;
import com.wip.model.AttAchDomain;
import com.wip.service.attach.AttAchService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AttAchServiceImplTest {
	@Autowired
	private AttAchService attAchService;
	
	@Test
	public void addAttAch() {
		AttAchDomain attach =new AttAchDomain();
		attach.setFname("123");
		attach.setFtype("123");
		attach.setFkey("123");
		attach.setId(1);
		attAchService.addAttAch(attach);
	}
	
	@Test
	public void getAtts() {
		PageInfo<AttAchDto> pageInfo = attAchService.getAtts(1, 15);
		System.out.println(pageInfo);
	}
	
	@Test
	public void getAttAchById() {
		attAchService.getAttAchById(7);
	}
	
	@Test
	public void deleteAttAch() {
		attAchService.deleteAttAch(8);
	}
}
