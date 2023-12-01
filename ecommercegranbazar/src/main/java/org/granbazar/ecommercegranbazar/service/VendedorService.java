package org.granbazar.ecommercegranbazar.service;

import java.util.List;
import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Vendedor;
import org.granbazar.ecommercegranbazar.repository.VendedorRepository;
import org.springframework.stereotype.Service;
@Service
public class VendedorService {
	
	private final VendedorRepository vendedorRepository;
	
	
	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}//constructor

	public List<Vendedor> getAllVendedores() {
		return vendedorRepository.findAll();
	}//getAllVendedores

	public Vendedor getVendedor(long id) {
		return vendedorRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El Vendedor con el id [" + id
						+ "] no existe")
				);
	}//getProducto

	public Vendedor deleteVendedor(long id) {
		Vendedor vend=null;
		if(vendedorRepository.existsById(id)) {
			vend = vendedorRepository.findById(id).get();
			vendedorRepository.deleteById(id);
		}//if existById
		return vend;
	}//deleteVendedor

	public Vendedor addVendedor(Vendedor vendedor) {
		  //TODO: validación
		  Optional<Vendedor> tmpVend= vendedorRepository.findByNombre (vendedor.getNombre());
		  if (tmpVend.isEmpty()) { //No se encuentra vendedor con ese nombre
		   return vendedorRepository.save(vendedor);
		  } else {
		   System.out.println("Ya existe el vendedor con el nombre ["
		     + vendedor.getNombre()+ "]");
		  return null;
		 } //else 

	}//addVendedor

	public Vendedor updateVendedor(long id, String nombre, String correo, Integer codigoPostal, String direccion, String telefono,
			String contrasena) {
		Vendedor vend = null;
		
			if(vendedorRepository.existsById(id)) {
				vend = vendedorRepository.findById(id).get();
				if (nombre!= null) vend.setNombre (nombre);
				if (correo!= null) vend.setCorreo (correo);
				if (codigoPostal!= null) vend.setCodigoPostal (codigoPostal);
				if (direccion!= null) vend.setDireccion (direccion);
				if (telefono!= null) vend.setTelefono (telefono);
				if (contrasena!= null) vend.setContrasena (contrasena);
				vendedorRepository.save(vend);   
			}//if
		return vend;
	}//updateVendedor
	
}//class
