package org.granbazar.ecommercegranbazar.repository;

import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
}//Interface UsuarioRepository

