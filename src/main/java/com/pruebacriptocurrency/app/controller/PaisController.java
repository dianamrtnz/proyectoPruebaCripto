package com.pruebacriptocurrency.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebacriptocurrency.app.entity.Pais;
import com.pruebacriptocurrency.app.service.PaisService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
	
	@Autowired
	private PaisService paisService; 
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Pais pais) {
		return ResponseEntity.status(HttpStatus.CREATED).body(paisService.save(pais));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable (value = "id") Long  idPais) {
		Optional<Pais> oUser = paisService.findById(idPais);
		
		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oUser);
		
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> update (@RequestBody Pais paisDetails, @PathVariable (value = "id") Long idPais) {
		Optional<Pais> pais = paisService.findById(idPais);
		
		if(pais.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		pais.get().setNombrePais(paisDetails.getNombrePais());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(paisService.save(pais.get())) ;
	
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete (@PathVariable(value= "id") Long idPais) {
		if (!paisService.findById(idPais).isPresent() ) {
			return ResponseEntity.notFound().build();
		}
		
		paisService.deleteById(idPais);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping 
	public List<Pais> readAll() {
		List<Pais> paises = StreamSupport
				.stream(paisService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return paises;
		
	}
}
	
	
	
	