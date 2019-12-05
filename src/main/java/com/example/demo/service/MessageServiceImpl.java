package com.example.demo.service;

import com.example.demo.dao.MessageRepository;
import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void saveMessage(Message message) {
        message.setTime(new Date());
        messageRepository.save(message);
    }



}
