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
			messageRepository.save(new Message("text1",new Date()));
			messageRepository.save(new Message("text2",new Date()));
			messageRepository.save(new Message("text3",new Date()));

			// fetch all messages
			log.info("Messages ");
			log.info("-------------------------------");
			for (Message mesg : messageRepository.findAll()) {
				log.info(mesg.toString());
			}
			log.info("");

			User user1 = new User();
			user1.setName("name1");

			Message m1 = new Message();
			m1.setText("text1");

			Set<Message> messageList = new HashSet<>();
			messageList.add(m1);

			user1.setMessageList(messageList);

			userRepository.save(user1);




		};
	}

}
