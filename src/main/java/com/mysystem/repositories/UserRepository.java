package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.dto.UserDTO;
import com.mysystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	UserDTO findByEmail(String email);

}
