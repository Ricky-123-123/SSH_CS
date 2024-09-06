package com.wip.service.option.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.service.option.OptionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionServiceImplTest {
	@Autowired
	private OptionService optionService;
	
	@Test
	public void getOptions() {
		optionService.getOptions();
	}
	
	@Test
	public void updateOptionByName() {
		optionService.updateOptionByName("123", "345");
	}
	
	@Test
	public void saveOptions() {
		Map<String, String> options =new HashMap<String, String>();
		options.put("555", "555");
		optionService.saveOptions(options);
	}
	
	@Test
	public void getOptionByName() {
		optionService.getOptionByName("site_title");
	}
}
