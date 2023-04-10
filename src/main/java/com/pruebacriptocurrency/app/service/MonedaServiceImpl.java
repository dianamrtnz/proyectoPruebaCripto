package com.pruebacriptocurrency.app.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebacriptocurrency.app.entity.Moneda;
import com.pruebacriptocurrency.app.repository.MonedaRepository;

@Service
public class MonedaServiceImpl implements MonedaService {

	@Autowired
	private MonedaRepository monedaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable <Moneda> findAll() {
		return monedaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Moneda> findAll(Pageable pageable) {
		return monedaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Moneda> findById(Long idMoneda) {
		return monedaRepository.findById(idMoneda);
	}

	@Override
	@Transactional
	public Moneda save(Moneda moneda) {
		return monedaRepository.save(moneda);
	
	}

	@Override
	@Transactional
	public void deleteById(Long idMoneda) {
		monedaRepository.deleteById(idMoneda);
		
	}


}