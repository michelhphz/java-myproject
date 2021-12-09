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

import com.mysystem.entities.Payment;
import com.mysystem.services.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/")
	public ResponseEntity<List<Payment>> findAll(){
		List<Payment> list = paymentService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Payment>> findById(@RequestBody Payment payment){
		Optional<Payment> paymentGet = paymentService.findById(payment.getId());
		return ResponseEntity.ok().body(paymentGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Payment payment) {
		paymentService.update(payment);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Payment payment) {
		paymentService.update(payment);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Payment payment) {
		paymentService.delete(payment);
		return ResponseEntity.ok();
	}	
}
