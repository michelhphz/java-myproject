package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
