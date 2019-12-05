package com.example.demo;

import com.example.demo.dao.MessageRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Message;
import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class DemoL1RestApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoL1RestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoL1RestApplication.class, args);
	}

	/**
	 * Persist data to H2 DB
	 */
	@Bean
	public CommandLineRunner demo(MessageRepository messageRepository, UserRepository userRepository){
		return (args) -> {

			User user1 = new User();
			user1.setName("name1");

			Message m1 = new Message();
			m1.setText("message1");
			m1.setTime(new Date());

			Message m2 = new Message();
			m2.setText("message2");
			m2.setTime(new Date());

			Set<Message> messageList = new HashSet<>();
			messageList.add(m1);
			messageList.add(m2);

			user1.setMessageList(messageList);

			userRepository.save(user1);

			//USER 2

			User user2 = new User();
			user2.setName("name2");

			Message m3 = new Message();
			m3.setText("message3");
			m3.setTime(new Date());

			messageList = new HashSet<>();
			messageList.add(m3);

			user2.setMessageList(messageList);

			userRepository.save(user2);

		};
	}

}
