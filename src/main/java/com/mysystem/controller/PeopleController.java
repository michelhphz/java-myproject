package com.mysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysystem.services.PeopleService;

@RestController
@RequestMapping(value = "/people")
//@Component
//@ViewScoped
public class PeopleController {
	
	@Autowired
	private PeopleService service;

	/*		
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
*/	
}
