package com.pruebacriptocurrency.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebacriptocurrency.app.entity.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long>{

}
