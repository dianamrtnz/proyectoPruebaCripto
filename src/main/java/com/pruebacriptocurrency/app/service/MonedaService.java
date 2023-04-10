package com.pruebacriptocurrency.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pruebacriptocurrency.app.entity.Moneda;

public interface MonedaService {
	
	public Iterable<Moneda> findAll();
	
	public Page<Moneda> findAll(Pageable pageable);
	
	public Optional<Moneda> findById(Long idMoneda);
	
	public Moneda save(Moneda moneda);
	
	public void deleteById(Long idMoneda);

}
