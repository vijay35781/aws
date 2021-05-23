package com.reactive.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.dao.UserDao;
import com.reactive.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebController {
	
	@Autowired
	UserDao userDao;
	
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getNames")
	public Mono<?> getUserNames(){
		
		List<String> names=Arrays.asList("vijay","vinay");
	return Mono.justOrEmpty(names);
		
	}
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get")
	public Mono<?> getDetails(){
		User user=new User();
		user.setAmount(4500);
		user.setName("vijay");
		user.setStatus("Paid");
		user.setType("GPay");
		userDao.save(user);
		List<User> users=new ArrayList<>();
		users.add(user);
		return Mono.justOrEmpty(users);
		
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Flux<?> updateDetails(){
		return null;
		
	}

}

