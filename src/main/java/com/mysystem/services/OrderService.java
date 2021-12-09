package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Order;
import com.mysystem.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		List<Order> list = orderRepository.findAll();
		return list;
	}
	
	public Optional<Order> findById(Long id){
		Optional<Order> orderFind = orderRepository.findById(id);
		return orderFind;
	}
	
	@Transactional
	public void insert(Order order) {
		orderRepository.save(order);
	}
	
	@Transactional
	public void delete(Order order) {
		orderRepository.delete(order);
	}
	
	@Transactional
	public void update(Order order) {
		orderRepository.save(order);
	}	
}
