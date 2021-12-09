package com.mysystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysystem.entities.Media;
import com.mysystem.repositories.MediaRepository;

@Service
public class MediaService {

	@Autowired
	private MediaRepository mediaRepository;
	
	public List<Media> findAll(){
		List<Media> list = mediaRepository.findAll();
		return list;
	}
	
	public Optional<Media> findById(Long id){
		Optional<Media> mediaFind = mediaRepository.findById(id);
		return mediaFind;
	}
	
	@Transactional
	public void insert(Media media) {
		mediaRepository.save(media);
	}
	
	@Transactional
	public void delete(Media media) {
		mediaRepository.delete(media);
	}
	
	@Transactional
	public void update(Media media) {
		mediaRepository.save(media);
	}	
}
