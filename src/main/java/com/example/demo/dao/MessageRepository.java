package com.example.demo.dao;

import com.example.demo.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Integer> {

}
