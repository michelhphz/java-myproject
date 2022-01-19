package com.mysystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysystem.entities.Post;
import com.mysystem.services.PostService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = postService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Post>> findById(@RequestBody Post post){
		Optional<Post> postGet = postService.findById(post.getId());
		return ResponseEntity.ok().body(postGet);
	}
	
	@PostMapping
	public ResponseEntity<Post> insert(@RequestBody Post post) {
		Post postInsert = postService.update(post);
		return ResponseEntity.ok().body(postInsert);
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Post post) {
		postService.update(post);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Post post) {
		postService.delete(post);
		return ResponseEntity.ok();
	}	
}
