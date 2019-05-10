package com.example.pruebaconcepto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaconcepto.model.Autenticacion;
import com.example.pruebaconcepto.services.AutenticacionService;

@CrossOrigin(origins = "*")
@RestController
public class AutenticacionController {
	
	@Autowired
	AutenticacionService autenticacionService;

	private static final String PREFIX = "/veterinaria";

	@GetMapping(value = PREFIX + "/consultarusuario/{user}/{pass}")
	public boolean consultarPorId(@PathVariable("user") String user, @PathVariable("pass") String pass) {
		return autenticacionService.consultarUsuario(user, pass);
	}
	
	@PostMapping(value = PREFIX + "/registrarusuario", consumes = "application/json", produces = "application/json")
	public boolean registrarUsuario(@RequestBody Autenticacion autenticacion) {
		autenticacionService.registrarUsuario(autenticacion);
		return autenticacion.getId() > 0;
	}
}
