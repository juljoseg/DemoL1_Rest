package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Message {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	private String text;

	private Date time;

	@ManyToOne()
	@JoinColumn(name = "user_id" , insertable = false , updatable = false)
	private User user;



	public Message() {}

	public Message(String text, Date time)
	{
		this.text = text;
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", text='" + text + '\'' +
				", time=" + time +
				'}';
	}
}
