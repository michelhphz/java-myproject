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

import com.mysystem.entities.Adress;
import com.mysystem.services.AdressService;

@RestController
@RequestMapping(value = "/adress")
public class AdressController {
	
	@Autowired
	private AdressService adressService;
	
	@GetMapping("/")
	public ResponseEntity<List<Adress>> findAll(){
		List<Adress> list = adressService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Adress>> findById(@RequestBody Adress adress){
		Optional<Adress> adressGet = adressService.findById(adress.getId());
		return ResponseEntity.ok().body(adressGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Adress adress) {
		adressService.update(adress);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Adress adress) {
		adressService.update(adress);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Adress adress) {
		adressService.delete(adress);
		return ResponseEntity.ok();
	}	
}
