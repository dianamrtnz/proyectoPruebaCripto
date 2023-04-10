package com.pruebacriptocurrency.app.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="paises")
public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1006784439909805331L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long idPais;
	
	@Column(length = 50, nullable=false, unique=true)
	private String nombrePais;
	
	@ManyToMany
	@JoinTable(name ="paises_monedas"
		,joinColumns=@JoinColumn(name = "pais_id")
		,inverseJoinColumns =@JoinColumn(name = "moneda_id")		
	)
	
	private Set<Moneda> monedas;

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	

}
