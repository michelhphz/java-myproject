package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Project;
import com.mysystem.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> findAll(){
		List<Project> list = projectRepository.findAll();
		return list;
	}
	
	public Optional<Project> findById(Long id){
		Optional<Project> projectFind = projectRepository.findById(id);
		return projectFind;
	}
	
	@Transactional
	public void insert(Project project) {
		projectRepository.save(project);
	}
	
	@Transactional
	public void delete(Project project) {
		projectRepository.delete(project);
	}
	
	@Transactional
	public void update(Project project) {
		projectRepository.save(project);
	}	
}
