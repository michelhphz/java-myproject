package com.mysystem.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.dto.UserDTO;
import com.mysystem.entities.User;
import com.mysystem.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public boolean findByEmail(String email, String password) {
		boolean response = false;
		UserDTO user = repository.findByEmail(email);
		if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
			response = true;
		}
		return response;
	}
	
	@Transactional
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User user = new User(null, dto.getEmail(), dto.getPassword());
		user = repository.save(user);
		return new UserDTO(user);
	}
}
