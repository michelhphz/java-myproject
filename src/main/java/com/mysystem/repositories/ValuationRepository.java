package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Valuation;

public interface ValuationRepository extends JpaRepository<Valuation, Long> {

}
