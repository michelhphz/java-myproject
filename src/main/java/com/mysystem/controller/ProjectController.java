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

import com.mysystem.entities.Project;
import com.mysystem.services.ProjectService;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/")
	public ResponseEntity<List<Project>> findAll(){
		List<Project> list = projectService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Optional<Project>> findById(@RequestBody Project project){
		Optional<Project> projectGet = projectService.findById(project.getId());
		return ResponseEntity.ok().body(projectGet);
	}
	
	@PostMapping
	public BodyBuilder insert(@RequestBody Project project) {
		projectService.update(project);
		return ResponseEntity.ok();
	}	
	
	@PutMapping
	public BodyBuilder uptade(@RequestBody Project project) {
		projectService.update(project);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping
	public BodyBuilder delete(@RequestBody Project project) {
		projectService.delete(project);
		return ResponseEntity.ok();
	}	
}
