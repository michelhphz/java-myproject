package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.People;
import com.mysystem.repositories.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;
	
	public List<People> findAll(){
		List<People> list = peopleRepository.findAll();
		return list;
	}
	
	public Optional<People> findById(Long id){
		Optional<People> peopleFind = peopleRepository.findById(id);
		return peopleFind;
	}
	
	@Transactional
	public void insert(People people) {
		peopleRepository.save(people);
	}
	
	@Transactional
	public void delete(People people) {
		peopleRepository.delete(people);
	}
	
	@Transactional
	public void update(People people) {
		peopleRepository.save(people);
	}	
}
