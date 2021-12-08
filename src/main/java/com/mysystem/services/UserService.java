package com.mysystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	/*		
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
*/	
}
