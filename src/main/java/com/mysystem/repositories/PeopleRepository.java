package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.People;

public interface PeopleRepository extends JpaRepository<People, Long> {
	
}
