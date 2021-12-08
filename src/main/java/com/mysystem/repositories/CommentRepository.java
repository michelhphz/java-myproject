package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
