package com.mysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysystem.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
