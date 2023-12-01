package org.granbazar.ecommercegranbazar.controller;

import java.util.List;

import org.granbazar.ecommercegranbazar.model.Comprador;
import org.granbazar.ecommercegranbazar.service.CompradorService;
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
@RequestMapping(path="/api/compradores/") //http://localhost:8080/api/compradores/
public class CompradorController {
	private final CompradorService compradorService;
	@Autowired
	public CompradorController(CompradorService compradorService) {
		this.compradorService = compradorService;
	}//constructor para inicializar Comprador
	
	@GetMapping
	public List<Comprador> getAllCompradores(){
		return compradorService.getAllCompradores();
	}//getAllComprador
	
	@GetMapping(path="{compId}")			//http://localhost:8080/api/vendedores/1
	public Comprador getComprador(@PathVariable("compId") long id){
		return compradorService.getComprador(id);
	}//getVendedor
	
	@DeleteMapping(path= "{compId}")  //http://localhost:8080/api/vendedores/1
	public Comprador deleteComprador(@PathVariable("compId") long id){
		return compradorService.deleteComprador(id);
	}//deleteVendedor

	@PostMapping 
	public Comprador addComprador(@RequestBody Comprador comprador) {
		 return compradorService.addComprador(comprador);
	}//addVendedor
	
	@PutMapping(path= "{compId}")
	public Comprador updateComprador(@PathVariable("compId") long id,
			@RequestParam(required= false) String nombre, 
			@RequestParam(required= false) String correo, 
			@RequestParam(required= false) String telefono,
			@RequestParam(required= false) String contrasena
			){ return compradorService.updateComprador(id, nombre, correo, telefono, contrasena); 
	}//updateVendedor
}//class
