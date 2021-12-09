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

import com.mysystem.entities.Lodge;
import com.mysystem.services.LodgeService;

@RestController
@RequestMapping(value = "/lodge")
public class LodgeController {
	
	@Autowired
	private LodgeService lodgeService;
	
	@GetMapping("/")
	public ResponseEntity<List<Lodge>> findAll(){
		List<Lodge> list = lodgeService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Lodge>> findById(@RequestBody Lodge lodge){
		Optional<Lodge> lodgeGet = lodgeService.findById(lodge.getId());
		return ResponseEntity.ok().body(lodgeGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Lodge lodge) {
		lodgeService.update(lodge);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Lodge lodge) {
		lodgeService.update(lodge);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Lodge lodge) {
		lodgeService.delete(lodge);
		return ResponseEntity.ok();
	}	
}
