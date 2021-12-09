package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Payment;
import com.mysystem.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> findAll(){
		List<Payment> list = paymentRepository.findAll();
		return list;
	}
	
	public Optional<Payment> findById(Long id){
		Optional<Payment> paymentFind = paymentRepository.findById(id);
		return paymentFind;
	}
	
	@Transactional
	public void insert(Payment payment) {
		paymentRepository.save(payment);
	}
	
	@Transactional
	public void delete(Payment payment) {
		paymentRepository.delete(payment);
	}
	
	@Transactional
	public void update(Payment payment) {
		paymentRepository.save(payment);
	}	
}
