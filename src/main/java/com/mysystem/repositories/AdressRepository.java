package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}
