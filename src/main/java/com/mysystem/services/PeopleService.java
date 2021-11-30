package com.mysystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.dto.PeopleDTO;
import com.mysystem.entities.People;
import com.mysystem.repositories.PeopleRepository;
import com.mysystem.services.exceptions.ResourceNotFoundException;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository repository;
		
	@Transactional
	public List<PeopleDTO> findAll(){
		List<People> list = repository.findAll();
		return list.stream().map(x -> new PeopleDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public PeopleDTO findByEmail(String email) {
		Optional<PeopleDTO> people = repository.findByEmail(email);		
		return people.orElseThrow(() -> new ResourceNotFoundException(email));
	}
	
	@Transactional
	public PeopleDTO insert(PeopleDTO dto) {
		People people = new People(null, dto.getEmail(), dto.getName(), dto.getBirth());
		people = repository.save(people);
		return new PeopleDTO(people);
	}
}
