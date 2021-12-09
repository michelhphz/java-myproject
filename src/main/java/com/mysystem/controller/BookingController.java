package com.mysystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysystem.entities.Booking;
import com.mysystem.services.BookingService;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/")
	public ResponseEntity<List<Booking>> findAll(){
		List<Booking> list = bookingService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Booking>> findById(@RequestBody Booking booking){
		Optional<Booking> bookingGet = bookingService.findById(booking.getId());
		return ResponseEntity.ok().body(bookingGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Booking booking) {
		bookingService.insert(booking);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Booking booking) {
		bookingService.update(booking);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Booking booking) {
		bookingService.delete(booking);
		return ResponseEntity.ok();
	}	
}
