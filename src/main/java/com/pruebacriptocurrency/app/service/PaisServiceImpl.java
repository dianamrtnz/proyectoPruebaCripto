package com.pruebacriptocurrency.app.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebacriptocurrency.app.entity.Pais;
import com.pruebacriptocurrency.app.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pais> findAll() {
		return paisRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pais> findAll(Pageable pageable) {
		return paisRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pais> findById(Long idPais) {
		return paisRepository.findById(idPais);
	}

	@Override
	@Transactional
	public Pais save(Pais pais) {
		return paisRepository.save(pais);
	
	}

	@Override
	@Transactional
	public void deleteById(Long idPais) {
		paisRepository.deleteById(idPais);
		
	}

}
