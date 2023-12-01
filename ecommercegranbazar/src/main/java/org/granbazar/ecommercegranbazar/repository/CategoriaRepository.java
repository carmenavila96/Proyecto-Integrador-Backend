package org.granbazar.ecommercegranbazar.repository;

import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	Optional<Categoria> findByNombre(String nombre);//método para encontrar nombre

}
