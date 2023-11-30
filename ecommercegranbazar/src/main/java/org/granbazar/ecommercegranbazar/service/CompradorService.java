package org.granbazar.ecommercegranbazar.service;

import java.util.ArrayList;

import org.granbazar.ecommercegranbazar.model.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompradorService {
	public final ArrayList<Comprador> lista = new ArrayList<Comprador>();
	
	@Autowired
	public CompradorService() {
		lista.add(new Comprador("Emilty", "emilty@gmail.com", "3142232789", "Cheeto21"));
		lista.add(new Comprador("Majo", "majo@hotmail.com", "5589651584", "Trakalosas123"));
		lista.add(new Comprador("Natividad", "natFu@gmail.com", "4431547895", "churro58"));
		lista.add(new Comprador("Lau", "lau@hotmail.com", "8452658963", "veggies23"));
		lista.add(new Comprador("Den", "deni@gmail.com", "1524569845", "chetito56"));
	}//constructor

	public ArrayList<Comprador> getAllCompradores() {
		return lista;
	}//getAllCompradores

	public Comprador getComprador(long id) {
		Comprador comp = null;
		for (Comprador comprador : lista) {
			if(id == comprador.getId()) {
				comp = comprador;
				break;
			}//if
		}//forEach
		return comp;
	}//getComprador

	public Comprador deleteComprador(long id) {
		Comprador comp = null;
		for (Comprador comprador : lista) {
			if(id == comprador.getId()) {
				comp = comprador;
				lista.remove(comprador);
				break;
			}//if
		}//forEach
		return comp;
	}//deleteVendedor

	public Comprador addComprador(Comprador comprador) {
		  lista.add(comprador);
		  return comprador;
	}//addComprador

	public Comprador updateComprador(long id, String nombre, String correo, String telefono,
			String contrasena) {
		Comprador comp = null;
		for (Comprador comprador : lista) {
			if(id == comprador.getId()) {
				if (nombre!= null) comprador.setNombre (nombre);
				if (correo!= null) comprador.setCorreo (correo);
				if (telefono!= null) comprador.setTelefono (telefono);
				if (contrasena!= null) comprador.setContrasena (contrasena);
				comp = comprador;
			    break;
			}//if
		}//forEach
		return comp;
	}//updateComprador
}//class
