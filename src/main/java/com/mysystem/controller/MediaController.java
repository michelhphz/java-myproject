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

import com.mysystem.entities.Media;
import com.mysystem.services.MediaService;

@RestController
@RequestMapping(value = "/media")
public class MediaController {
	
	@Autowired
	private MediaService mediaService;
	
	@GetMapping("/")
	public ResponseEntity<List<Media>> findAll(){
		List<Media> list = mediaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Media>> findById(@RequestBody Media media){
		Optional<Media> mediaGet = mediaService.findById(media.getId());
		return ResponseEntity.ok().body(mediaGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Media media) {
		mediaService.update(media);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Media media) {
		mediaService.update(media);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Media media) {
		mediaService.delete(media);
		return ResponseEntity.ok();
	}	
}
