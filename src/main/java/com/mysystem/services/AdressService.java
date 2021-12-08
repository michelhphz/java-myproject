package com.mysystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Adress;
import com.mysystem.repositories.AdressRepository;

@Service
public class AdressService {
	
	@Autowired
	private AdressRepository adressRepository;
		
	public List<Adress> findAll(){
		List<Adress> list = adressRepository.findAll();
		return list;
	}
	
	public Adress findById(Adress adress) {
		Adress adressFind = adressRepository.getById(adress.getId());
		return adressFind;
	}
	
	@Transactional
	public void insert(Adress adress) {
		adressRepository.save(adress);
	}
	
	@Transactional
	public void delete(Adress adress) {
		adressRepository.delete(adress);
	}
	
	@Transactional
	public void update(Adress adress) {
		adressRepository.save(adress);
	}
}
