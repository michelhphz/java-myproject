package com.mysystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.dto.PeopleDTO;
import com.mysystem.entities.People;

public interface PeopleRepository extends JpaRepository<People, Long> {
	
	Optional<PeopleDTO> findByEmail(String email);
}
