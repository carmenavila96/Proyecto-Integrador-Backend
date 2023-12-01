package org.granbazar.ecommercegranbazar.repository;

import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
	Optional<Vendedor> findByNombre(String nombre);//método para encontrar nombre
}
