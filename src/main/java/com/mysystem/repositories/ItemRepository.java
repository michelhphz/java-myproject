package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
