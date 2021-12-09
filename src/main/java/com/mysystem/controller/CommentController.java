package com.mysystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysystem.entities.Comment;
import com.mysystem.services.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/")
	public ResponseEntity<List<Comment>> findAll(){
		List<Comment> list = commentService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Comment>> findById(@RequestBody Comment comment){
		Optional<Comment> commentGet = commentService.findById(comment.getId());
		return ResponseEntity.ok().body(commentGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Comment comment) {
		commentService.update(comment);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Comment comment) {
		commentService.update(comment);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Comment comment) {
		commentService.delete(comment);
		return ResponseEntity.ok();
	}	
}
