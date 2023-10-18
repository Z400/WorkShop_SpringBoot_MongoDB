package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List <User> findAll () {
		return repo.findAll();
	}
 
	 public User insert (User obj) {
		 return repo.insert(obj);
	 }
	 
	 
	 public void delete(String id){
		 repo.deleteById(id);
	 }
	 
	 public User fromDto (UserDto objDto) {
		 return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	 }
	
	 
	 	
 }
