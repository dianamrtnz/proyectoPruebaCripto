package com.pruebacriptocurrency.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="monedas")
public class Moneda implements Serializable{
	
	private static final long serialVersionUID = 5546889804259383849L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long idMoneda;
	
	@Column(length = 50, nullable=false, unique=true)
	private String moneda;
	
	@Column(length = 50, nullable=false)
	private String simbolo;
	
	@Column(length = 50, nullable=false)
	private Double valorMoneda;
	

	public Long getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(Long idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Double getValorMoneda() {
		return valorMoneda;
	}

	public void setValorMoneda(Double valorMoneda) {
		this.valorMoneda = valorMoneda;
	}
	

	
	

}
