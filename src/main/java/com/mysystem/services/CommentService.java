package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Comment;
import com.mysystem.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findAll(){
		List<Comment> list = commentRepository.findAll();
		return list;
	}
	
	public Optional<Comment> findById(Long id){
		Optional<Comment> commentFind = commentRepository.findById(id);
		return commentFind;
	}
	
	@Transactional
	public void insert(Comment Comment) {
		commentRepository.save(Comment);
	}
	
	@Transactional
	public void delete(Comment Comment) {
		commentRepository.delete(Comment);
	}
	
	@Transactional
	public void update(Comment Comment) {
		commentRepository.save(Comment);
	}	
}
