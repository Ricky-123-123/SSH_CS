package com.wip.service.user.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.model.UserDomain;
import com.wip.service.user.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	private UserService userServiceImp;
	
	@Test
	public void login() {
		String userName="123";		
		String passWord ="456";				
		UserDomain userDomain=userServiceImp.login(userName, passWord);	
		System.out.println(userDomain);
	}
	
	@Test
	public void getUserInfoById() {
		UserDomain userDomain=userServiceImp.getUserInfoById(1);
		System.out.println(userDomain);
	}
	
	@Test
	public void updateUserInfo() {
		UserDomain userDomain =new UserDomain();
		userDomain.setUid(2);
		userDomain.setUsername("456");
		userDomain.setPassword("456");
		Integer i=userServiceImp.updateUserInfo(userDomain);
		System.out.println(i);
	}
}
