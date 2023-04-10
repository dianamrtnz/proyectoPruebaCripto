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

import com.pruebacriptocurrency.app.entity.Moneda;
import com.pruebacriptocurrency.app.entity.Pais;
import com.pruebacriptocurrency.app.service.MonedaService;
import com.pruebacriptocurrency.app.service.PaisService;

@RestController
@RequestMapping("/api/monedas")
public class MonedaController {
	
	@Autowired
	private MonedaService monedaService; 
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Moneda moneda) {
		return ResponseEntity.status(HttpStatus.CREATED).body(monedaService.save(moneda));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable (value = "id") Long  idMoneda) {
		Optional<Moneda> oUser = monedaService.findById(idMoneda);
		
		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oUser);
		
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> update (@RequestBody Moneda monedaDetails, @PathVariable (value = "id") Long idMoneda) {
		Optional<Moneda> moneda = monedaService.findById(idMoneda);
		
		if(moneda.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		moneda.get().setMoneda(monedaDetails.getMoneda());
		moneda.get().setSimbolo(monedaDetails.getSimbolo());
		moneda.get().setValorMoneda(monedaDetails.getValorMoneda());

			
		return ResponseEntity.status(HttpStatus.CREATED).body(monedaService.save(moneda.get())) ;
	
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete (@PathVariable(value= "id") Long idMoneda) {
		if (!monedaService.findById(idMoneda).isPresent() ) {
			return ResponseEntity.notFound().build();
		}
		
		monedaService.deleteById(idMoneda);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping 
	public List<Moneda> readAll() {
		List<Moneda> monedas = StreamSupport
				.stream(monedaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return monedas;
		
	}
}
	
	