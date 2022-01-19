package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
