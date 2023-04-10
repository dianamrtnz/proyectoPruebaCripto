package com.pruebacriptocurrency.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pruebacriptocurrency.app.entity.Pais;

public interface PaisService {
	
	public Iterable<Pais> findAll();
	
	public Page<Pais> findAll(Pageable pageable);
	
	public Optional<Pais> findById(Long idPais);
	
	public Pais save(Pais pais);
	
	public void deleteById(Long idPais);
	

}
