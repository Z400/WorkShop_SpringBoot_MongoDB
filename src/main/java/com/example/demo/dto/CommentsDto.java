package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentsDto implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
	private AuthorDto authotDto;
	
 public CommentsDto () {
	 
 }

public CommentsDto(String text, Date date, AuthorDto authotDto) {
	super();
	this.text = text;
	this.date = date;
	this.authotDto = authotDto;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public AuthorDto getAuthotDto() {
	return authotDto;
}

public void setAuthotDto(AuthorDto authotDto) {
	this.authotDto = authotDto;
}
 


 
	
	
}
