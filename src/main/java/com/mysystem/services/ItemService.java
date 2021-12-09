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
		Optional<Item> ItemFind = itemRepository.findById(id);
		return ItemFind;
	}
	
	@Transactional
	public void insert(Item Item) {
		itemRepository.save(Item);
	}
	
	@Transactional
	public void delete(Item Item) {
		itemRepository.delete(Item);
	}
	
	@Transactional
	public void update(Item Item) {
		itemRepository.save(Item);
	}	
}
