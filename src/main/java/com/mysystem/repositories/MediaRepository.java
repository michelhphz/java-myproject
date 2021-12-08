package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
