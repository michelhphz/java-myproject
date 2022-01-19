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

import com.mysystem.entities.Category;
import com.mysystem.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok().body(categoryService.findAll());
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Category>> findByID(@RequestBody Category entity){
		return ResponseEntity.ok().body(categoryService.findByID(entity.getId()));
	}
	
	@PostMapping
	public BodyBuilder insertCategory(@RequestBody Category entity) {
		categoryService.insertCategory(entity);
		return ResponseEntity.ok();
	}
	
	@PutMapping
	public BodyBuilder updateCategory(@RequestBody Category entity) {
		categoryService.updateCategory(entity);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder deleteCategory(@RequestBody Category entity) {
		categoryService.deleteCategory(entity);
		return ResponseEntity.ok();
	}	
}
