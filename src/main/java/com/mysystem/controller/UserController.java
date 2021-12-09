package com.mysystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysystem.entities.User;
import com.mysystem.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<User>> findById(@RequestBody User user){
		Optional<User> userGet = userService.findById(user.getId());
		return ResponseEntity.ok().body(userGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody User user) {
		userService.update(user);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody User user) {
		userService.update(user);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody User user) {
		userService.delete(user);
		return ResponseEntity.ok();
	}	
}
