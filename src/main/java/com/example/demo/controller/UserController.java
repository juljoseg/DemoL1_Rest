package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;


@RestController
public class UserController {

	
	@RequestMapping("/message")
	public String greeting(@RequestBody Message message) {
		System.out.println(" --------------> message : " + message == null ? "" : message.getText());
		return message.getText();
	}
	
}
