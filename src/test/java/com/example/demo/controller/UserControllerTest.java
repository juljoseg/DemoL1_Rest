package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.example.demo.model.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.MessageServiceImpl;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;

	@Mock
	MessageServiceImpl messageService;

	@Mock
	UserServiceImpl userService;

	
	@Test
	public void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}

	@Test
	public void testGetUser() {
		User user = new User("test");

		when(userService.findUserByName(anyString())).thenReturn(user);

		Assert.assertEquals(user,userController.getUser("name"));
	}

}