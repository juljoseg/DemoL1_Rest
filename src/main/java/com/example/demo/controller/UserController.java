package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Message;


@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/message" , method = RequestMethod.PUT)
	public String greeting(@RequestBody Message message) {
		log.info(" --------------> message : " + message == null ? "" : message.getText());
		messageService.saveMessage(message);
		return message.getText();
	}

	@RequestMapping(value = "/getUser" , method = RequestMethod.GET)
	public User getUser(@RequestParam(value="name") String name) {

		return userService.findUserByName(name);
	}

	@RequestMapping(value = "/user" , method = RequestMethod.PUT)
	public void saveUser(@RequestBody User user) {
		userService.saveUser (user);
	}
	
}
