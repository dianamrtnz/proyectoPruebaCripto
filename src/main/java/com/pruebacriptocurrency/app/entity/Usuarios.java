package com.pruebacriptocurrency.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Usuarios {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="idusuario")
	private Integer id;
	
	private String nombre;
	private String email;
	private String password;
	
}
