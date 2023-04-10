package com.pruebacriptocurrency.app.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name= "user")
public class User implements Serializable{

	private static final long serialVersionUID = -5265441820702774657L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private Long cedula;
	
	@Column(nullable=false, length = 50)
	private String nombre;
	
	@Column(nullable=false, length = 50)
	private String apellidos;
	
	@Column(nullable=false, length = 1)
	private String tipoCliente;
	
	//@Column(nullable=false)
	//private Long idPais;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idPais", nullable = false, unique=true)
	private Pais paises;
	

	public Pais getPaises() {
		return paises;
	}

	public void setPaises(Pais paises) {
		this.paises = paises;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	//public Long getIdPais() {
		//return idPais;
	//}

	//public void setIdPais(Long idPais) {
		//this.idPais = idPais;
	//}
	
	
	
	
}
