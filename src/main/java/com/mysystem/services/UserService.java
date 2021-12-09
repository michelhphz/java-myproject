package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.User;
import com.mysystem.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		List<User> list = userRepository.findAll();
		return list;
	}
	
	public Optional<User> findById(Long id){
		Optional<User> userFind = userRepository.findById(id);
		return userFind;
	}
	
	@Transactional
	public void insert(User user) {
		userRepository.save(user);
	}
	
	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	@Transactional
	public void update(User user) {
		userRepository.save(user);
	}	
}
