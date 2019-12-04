package com.example.demo.controller;


import com.example.demo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;


@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MessageService messageService;


	@RequestMapping("/message")
	public String greeting(@RequestBody Message message) {
		log.info(" --------------> message : " + message == null ? "" : message.getText());
		messageService.saveMessage(message);
		return message.getText();
	}
	
}
