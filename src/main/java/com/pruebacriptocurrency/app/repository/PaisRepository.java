package com.pruebacriptocurrency.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebacriptocurrency.app.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
