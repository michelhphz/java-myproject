package com.mysystem.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mysystem.dto.PeopleDTO;
import com.mysystem.services.PeopleService;

@RestController
@RequestMapping(value = "/people")
//@Component
//@ViewScoped
public class PeopleRest {
	
	@Autowired
	private PeopleService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<PeopleDTO>> findAll(){
		List<PeopleDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/email")
	public ResponseEntity<PeopleDTO> findByEmail(@RequestBody PeopleDTO dto) {
		dto = service.findByEmail(dto.getEmail());
		return ResponseEntity.ok().body(dto);		
	}
	
	@PostMapping
	public ResponseEntity<PeopleDTO> insert(@RequestBody PeopleDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
}
