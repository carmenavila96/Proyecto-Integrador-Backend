package org.granbazar.ecommercegranbazar.controller;

import javax.servlet.ServletException;

import org.granbazar.ecommercegranbazar.config.JwtFilter;
import org.granbazar.ecommercegranbazar.model.Usuario;
import org.granbazar.ecommercegranbazar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.granbazar.ecommercegranbazar.model.Token;

import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/") //http://localhost:8080/api/login/
public class LoginController {

	private final UsuarioService usuarioService; //me provee de mis datos de usuario y contrasena
    
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}//constructor
	
	@PostMapping
	public Token loginUsuario(@RequestBody Usuario usuario) throws ServletException{
		if(usuarioService.validateUser(usuario)) {
			System.out.println("usuario válido" + usuario.getEmail());
			return new Token(generateToken(usuario.getEmail()));
		}//if
		
		throw new ServletException("Nombre de usuario o contrasena incorrectos");
	}//loginUsuario
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
	
	
	
	
}//class LoginController
