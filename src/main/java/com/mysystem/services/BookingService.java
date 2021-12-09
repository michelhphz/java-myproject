package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Booking;
import com.mysystem.repositories.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> findAll(){
		List<Booking> list = bookingRepository.findAll();
		return list;
	}
	
	public Optional<Booking> findById(Long id) {
		Optional<Booking> bookingFind = bookingRepository.findById(id);
		return bookingFind;
	}
	
	@Transactional
	public void insert(Booking booking) {
		bookingRepository.save(booking);
	}
	
	@Transactional
	public void delete(Booking booking) {
		bookingRepository.delete(booking);
	}
	
	@Transactional
	public void uptade(Booking booking) {
		bookingRepository.save(booking);
	}
}
