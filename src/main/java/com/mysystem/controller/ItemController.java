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

import com.mysystem.entities.Item;
import com.mysystem.services.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	public ResponseEntity<List<Item>> findAll(){
		List<Item> list = itemService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Item>> findById(@RequestBody Item item){
		Optional<Item> itemGet = itemService.findById(item.getId());
		return ResponseEntity.ok().body(itemGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Item item) {
		itemService.update(item);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Item item) {
		itemService.update(item);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Item item) {
		itemService.delete(item);
		return ResponseEntity.ok();
	}	
}
