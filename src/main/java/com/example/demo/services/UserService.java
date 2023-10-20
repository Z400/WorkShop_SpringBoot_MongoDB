package com.example.demo.services;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<User> findById (User obj) {
		return repo.findById(obj.getId());
	}
 
	 public User insert (User obj) {
		 return repo.insert(obj);
	 }
	 
	 
	 public void delete(String id){
		 repo.deleteById(id);
	 }
	 
	 public User update (User obj) {
		 Optional<User> newObj = repo.findById(obj.getId());
		 updateData (newObj, obj);
		return  repo.save(newObj.get());
	 }
	 
	 
	 
	 private void updateData(Optional<User> newObj, User obj) {
		 newObj.get().setEmail(obj.getEmail());
		 newObj.get().setName(obj.getName());
	}

	public User fromDto (UserDto objDto) {
		 return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	 }

 
	
	 
	 	
 }
