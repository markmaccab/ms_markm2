package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Userpre;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service; 

//MySQL DB	

	@RequestMapping(method=RequestMethod.GET,path="/users")
	public List<Userpre> fetchUserList() {
		return service.fetchUserList();
	}

	
	@GetMapping("user/{id}") //		@PathVariable("id")
	public Userpre getUserpreById(@PathVariable String id)	{
		return service.getUserpreById(Integer.parseInt(id));
	}
	
	
  	@PostMapping("/users")
	Integer createUser(@RequestBody Userpre userpre) {
  		if (userpre==null) {
  			throw new RuntimeException();
  		}
		return service.saveUser(userpre);
  	}

//static table 	
  	
	@RequestMapping(method=RequestMethod.GET,path="/api/users")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	
	@GetMapping("/api/user/{id}") 
	public User getUserById(@PathVariable String id)	{
		return service.getUserById(Integer.parseInt(id));
	}



}
