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

import com.mysystem.entities.People;
import com.mysystem.services.PeopleService;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/")
	public ResponseEntity<List<People>> findAll(){
		List<People> list = peopleService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<People>> findById(@RequestBody People people){
		Optional<People> peopleGet = peopleService.findById(people.getId());
		return ResponseEntity.ok().body(peopleGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody People people) {
		peopleService.update(people);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody People people) {
		peopleService.update(people);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody People people) {
		peopleService.delete(people);
		return ResponseEntity.ok();
	}	
}
