package org.granbazar.ecommercegranbazar.service;

import java.util.List;
import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.ChangePassword;
import org.granbazar.ecommercegranbazar.model.Usuario;
import org.granbazar.ecommercegranbazar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}//constructor
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}//getAllUsuarios
	
	
    public Usuario getUser(long id) {
		
	    return usuarioRepository.findById(id).orElseThrow(
			()-> new IllegalArgumentException("El usuario con el id [" + id
						+ "] no existe")
		);
		
	}//getUser
    

	public Usuario deleteUsuario(long id) {
		Usuario user=null;
		
		if(usuarioRepository.existsById(id)){//asegurarme de que existe el usuario, y si existe el usuraio lo traiga
			user = usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}//if existById
		
		return user;
	}//deleteUser
	
	public Usuario addUsuario(Usuario usuario) {
		
		Usuario user = null;
		
		if (usuarioRepository.findByEmail(usuario.getEmail()).isEmpty()) { //no se encuentra el producto con ese nombre
			//Cifrar la contrasena
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			user = usuarioRepository.save(usuario);
		} else {
			System.out.println("El usuario con el email ["
					+ usuario.getEmail() + "] ya se encuentra registrado"); 
		}//if IsEmpty
		return user;
	}//addUser
	
	public Usuario updateUser(Long id, ChangePassword changePassword) {
		Usuario user=null;
			
			if(usuarioRepository.existsById(id)){
				user = usuarioRepository.findById(id).get();
				
				if(passwordEncoder.matches(changePassword.getPassword(), user.getPassword())) {
				//if(user.getPassword().equals(changePassword.getPassword())){
					
					user.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
					usuarioRepository.save(user);
				}else{
					System.out.println("updateUser - El password es incorrecto id ["
							+ id + "]"); 
					user = null;
				}//if equals
				
			}else {
				System.out.println("updateUser - El usuario con el id ["
						+ id + "] No se encuentra registrado"); 
				
			}//else //if existById
			
			return user;
	}//updateUser
	
	
	public boolean validateUser(Usuario usuario) {
		Optional<Usuario> userByEmail = usuarioRepository.findByEmail(usuario.getEmail());
		if (userByEmail.isPresent()) {
			Usuario user = userByEmail.get();
			if(passwordEncoder.matches(usuario.getPassword(), user.getPassword())) {
				return true;
			}//if password equals
			
		}//if isPresent
		
		return false;
	}//ValidateUser
	

}//UsuarioService
