package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Lodge;

public interface LodgeRepository extends JpaRepository<Lodge, Long> {

}
