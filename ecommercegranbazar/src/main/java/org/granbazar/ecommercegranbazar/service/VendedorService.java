package org.granbazar.ecommercegranbazar.service;

import java.util.ArrayList;

import org.granbazar.ecommercegranbazar.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VendedorService {
	public final ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
	
	@Autowired
	public VendedorService() {
		lista.add(new Vendedor("Jaqui", "jacjac@hotmail.com", 54236, "Av Morelos 53", "5514856985", "piopio59"));
		lista.add(new Vendedor("Esteph", "esteph@hotmail.com", 48526, "Blv Arriaga 48", "6512548952", "gatito01"));
		lista.add(new Vendedor("Carmen", "carmenav@gmail.com", 58412, "Av Camelinas", "4431547852", "Guts22"));
		lista.add(new Vendedor("Caro", "caro@hotmail.com", 48523, "Av Madero 22", "4584125632","perrito8"));
		lista.add(new Vendedor("Ruth", "ruth@hotmail.com", 89521, "Av Jesús", "4512458963","patito23"));
	}//constructor

	public ArrayList<Vendedor> getAllVendedores() {
		return lista;
	}//getAllVendedores

	public Vendedor getVendedor(long id) {
		Vendedor vend = null;
		for (Vendedor vendedor : lista) {
			if(id == vendedor.getId()) {
				vend = vendedor;
				break;
			}//if
		}//forEach
		return vend;
	}//getVendedor

	public Vendedor deleteVendedor(long id) {
		Vendedor vend = null;
		for (Vendedor vendedor : lista) {
			if(id == vendedor.getId()) {
				vend = vendedor;
				lista.remove(vendedor);
				break;
			}//if
		}//forEach
		return vend;
	}//deleteVendedor

	public Vendedor addVendedor(Vendedor vendedor) {
		 lista.add(vendedor);
		 return vendedor;
	}//addVendedor

	public Vendedor updateVendedor(long id, String nombre, String correo, Integer codigoPostal, String direccion, String telefono,
			String contrasena) {
		Vendedor vend = null;
		for (Vendedor vendedor : lista) {
			if(id == vendedor.getId()) {
				if (nombre!= null) vendedor.setNombre (nombre);
				if (correo!= null) vendedor.setCorreo (correo);
				if (codigoPostal!= null) vendedor.setCodigoPostal (codigoPostal);
				if (direccion!= null) vendedor.setDireccion (direccion);
				if (telefono!= null) vendedor.setTelefono (telefono);
				if (contrasena!= null) vendedor.setContrasena (contrasena);
				vend = vendedor;
			    break;
			}//if
		}//forEach
		return vend;
	}//updateVendedor
}//class
