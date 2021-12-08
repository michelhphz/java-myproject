package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
