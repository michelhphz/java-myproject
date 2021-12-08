package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
