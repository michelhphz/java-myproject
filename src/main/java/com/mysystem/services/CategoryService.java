package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Category;
import com.mysystem.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Optional<Category> findByID(Long id) {
		return categoryRepository.findById(id);
	}
	
	public void insertCategory(Category entity) {
		categoryRepository.save(entity);
	}
	
	public void updateCategory(Category entity) {
		categoryRepository.save(entity);
	}
	
	public void deleteCategory(Category entity) {
		categoryRepository.delete(entity);
	}
	
}
