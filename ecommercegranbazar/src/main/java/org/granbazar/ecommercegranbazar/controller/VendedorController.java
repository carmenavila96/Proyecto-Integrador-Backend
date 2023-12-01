package org.granbazar.ecommercegranbazar.controller;

import java.util.List;

import org.granbazar.ecommercegranbazar.model.Vendedor;
import org.granbazar.ecommercegranbazar.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/vendedores/") //http://localhost:8080/api/vendedores/
public class VendedorController {
	private final VendedorService vendedorService;
	@Autowired
	public VendedorController(VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}//constructor para inicializar Vendedor
	
	@GetMapping
	public List<Vendedor> getAllVendedores(){
		return vendedorService.getAllVendedores();
	}//getAllVendedores
	
	@GetMapping(path="{vendId}")			//http://localhost:8080/api/vendedores/1
	public Vendedor getVendedor(@PathVariable("vendId") long id){
		return vendedorService.getVendedor(id);
	}//getVendedor
	
	@DeleteMapping(path= "{vendId}")  //http://localhost:8080/api/vendedores/1
	public Vendedor deleteVendedor(@PathVariable("vendId") long id){
		return vendedorService.deleteVendedor(id);
	}//deleteVendedor

	@PostMapping 
	public Vendedor addVendedor(@RequestBody Vendedor vendedor) {
		 return vendedorService.addVendedor(vendedor);
	}//addVendedor
	
	@PutMapping(path= "{vendId}")
	public Vendedor updateVendedor(@PathVariable("vendId") long id,
			@RequestParam(required= false) String nombre, 
			@RequestParam(required= false) String correo, 
			@RequestParam(required= false) Integer codigoPostal, 
			@RequestParam(required= false) String direccion, 
			@RequestParam(required= false) String telefono,
			@RequestParam(required= false) String contrasena
			){ return vendedorService.updateVendedor(id, nombre, correo, codigoPostal, direccion, telefono, contrasena); 
	}//updateVendedor
}//class
