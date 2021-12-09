package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Item;
import com.mysystem.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findAll(){
		List<Item> list = itemRepository.findAll();
		return list;
	}
	
	public Optional<Item> findById(Long id){
		Optional<Item> itemFind = itemRepository.findById(id);
		return itemFind;
	}
	
	@Transactional
	public void insert(Item item) {
		itemRepository.save(item);
	}
	
	@Transactional
	public void delete(Item item) {
		itemRepository.delete(item);
	}
	
	@Transactional
	public void update(Item item) {
		itemRepository.save(item);
	}	
}
