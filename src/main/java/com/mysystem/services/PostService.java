package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Post;
import com.mysystem.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		List<Post> list = postRepository.findAll();
		return list;
	}
	
	public Optional<Post> findById(Long id){
		Optional<Post> postFind = postRepository.findById(id);
		return postFind;
	}
	
	@Transactional
	public void insert(Post post) {
		postRepository.save(post);
	}
	
	@Transactional
	public void delete(Post post) {
		postRepository.delete(post);
	}
	
	@Transactional
	public Post update(Post post) {
		return postRepository.save(post);
	}	
}
