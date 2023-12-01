package org.granbazar.ecommercegranbazar.service;

import java.util.List;
import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Comprador;
import org.granbazar.ecommercegranbazar.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompradorService {
	
	private final CompradorRepository compradorRepository;
	
	@Autowired
	public CompradorService(CompradorRepository compradorRepository) {
		  this.compradorRepository = compradorRepository;
		 } //constructor

	public List<Comprador> getAllCompradores() {
		  return compradorRepository.findAll();
		 }//getAllComprador

	public Comprador getComprador(long id) {
		  return compradorRepository.findById(id).orElseThrow(
		         ()-> new IllegalArgumentException("El comprador con el id [" + id 
		           + "] no existe")
		  );
		 } //getComprador

	public Comprador deleteComprador(long id) {
		  Comprador comp = null;
		  if (compradorRepository.existsById(id)) {
		   comp = compradorRepository.findById(id).get();
		   compradorRepository.deleteById(id);
		  }//if existById
		 return comp;
		 }//deleteComprador

	public Comprador addComprador(Comprador comprador) {
		  //TODO: validación
		  Optional<Comprador> tmpProd= compradorRepository.findByNombre (comprador.getNombre());
		  if (tmpProd.isEmpty()) { //No se encuentra comprador con ese nombre
		   return compradorRepository.save(comprador);
		  } else {
		   System.out.println("Ya existe el comprador con el nombre ["
		     + comprador.getNombre()+ "]");
		  return null;
		 } //else
		}//addComprador

	
	public Comprador updateComprador(long id, String nombre, String correo, String telefono,
			String contrasena) {
		Comprador comp = null;
		if(compradorRepository.existsById(id)) {
			 comp = compradorRepository.findById(id).get();
			 
			   if (nombre!= null) comp.setNombre (nombre);
			   if (correo!= null) comp.setCorreo(correo);
			   if (telefono!= null) comp.setTelefono(telefono);
			   if (contrasena!= null) comp.setContrasena (contrasena);
			
			compradorRepository.save(comp);
		}//existById
		return comp;
	}//updateProducto
	
	
}//class
