package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
		
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	public ResponseEntity <List<UserDto>> findAll() {
		
		List <User> list = service.findAll();
		List <UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(listDto);
	} 
	
	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody UserDto objDto){
		User obj = service.fromDto(objDto);
		obj = service.insert(obj);
 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
 return ResponseEntity.created(uri).build();
}
	
		
	 

}
