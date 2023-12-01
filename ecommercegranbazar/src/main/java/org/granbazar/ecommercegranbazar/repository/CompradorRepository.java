package org.granbazar.ecommercegranbazar.repository;

import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long>{
	
	 Optional<Comprador> findByNombre(String nombre);

	}//interface CompradorRepository