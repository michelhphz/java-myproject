package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Lodge;
import com.mysystem.repositories.LodgeRepository;

@Service
public class LodgeService {

	@Autowired
	private LodgeRepository lodgeRepository;
	
	public List<Lodge> findAll(){
		List<Lodge> list = lodgeRepository.findAll();
		return list;
	}
	
	public Optional<Lodge> findById(Long id){
		Optional<Lodge> LodgeFind = lodgeRepository.findById(id);
		return LodgeFind;
	}
	
	@Transactional
	public void insert(Lodge Lodge) {
		lodgeRepository.save(Lodge);
	}
	
	@Transactional
	public void delete(Lodge Lodge) {
		lodgeRepository.delete(Lodge);
	}
	
	@Transactional
	public void update(Lodge Lodge) {
		lodgeRepository.save(Lodge);
	}	
}
