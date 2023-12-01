package org.granbazar.ecommercegranbazar.repository;

import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long>{
	
	Optional<Venta> findById(Long id);//método para encontrar id

}
