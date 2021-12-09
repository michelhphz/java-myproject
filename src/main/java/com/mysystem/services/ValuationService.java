package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Valuation;
import com.mysystem.repositories.ValuationRepository;

@Service
public class ValuationService {

	@Autowired
	private ValuationRepository valuationRepository;
	
	public List<Valuation> findAll(){
		List<Valuation> list = valuationRepository.findAll();
		return list;
	}
	
	public Optional<Valuation> findById(Long id){
		Optional<Valuation> valuationFind = valuationRepository.findById(id);
		return valuationFind;
	}
	
	@Transactional
	public void insert(Valuation valuation) {
		valuationRepository.save(valuation);
	}
	
	@Transactional
	public void delete(Valuation valuation) {
		valuationRepository.delete(valuation);
	}
	
	@Transactional
	public void update(Valuation valuation) {
		valuationRepository.save(valuation);
	}	
}
