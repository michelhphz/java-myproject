package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
