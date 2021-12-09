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

import com.mysystem.entities.Valuation;
import com.mysystem.services.ValuationService;

@RestController
@RequestMapping(value = "/valuation")
public class ValuationController {
	
	@Autowired
	private ValuationService valuationService;
	
	@GetMapping("/")
	public ResponseEntity<List<Valuation>> findAll(){
		List<Valuation> list = valuationService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Valuation>> findById(@RequestBody Valuation valuation){
		Optional<Valuation> valuationGet = valuationService.findById(valuation.getId());
		return ResponseEntity.ok().body(valuationGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Valuation valuation) {
		valuationService.update(valuation);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Valuation valuation) {
		valuationService.update(valuation);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Valuation valuation) {
		valuationService.delete(valuation);
		return ResponseEntity.ok();
	}	
}
