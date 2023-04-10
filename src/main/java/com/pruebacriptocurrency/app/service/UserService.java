package com.pruebacriptocurrency.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pruebacriptocurrency.app.entity.User;

public interface UserService {

	public Iterable<User> findAll();
	
	public Page<User> findAll (Pageable Pageable);
	
	public Optional<User> findById (Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
	
	
}