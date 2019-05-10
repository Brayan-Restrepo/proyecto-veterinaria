package com.example.pruebaconcepto.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaconcepto.model.Propietario;
import com.example.pruebaconcepto.services.PropietarioService;

@CrossOrigin(origins = "*")
@RestController
public class PropietarioController {
	
	@Autowired
    PropietarioService propietarioService;

	private static final String PREFIX = "/veterinaria";

	@PostMapping(value = PREFIX + "/registrarpropietario", consumes = "application/json", produces = "application/json")
	public int registrarPropietario(@RequestBody Propietario propietario) {
		propietarioService.registrarPropietario(propietario);
		return propietario.getId();
	}
	
    @GetMapping(value = PREFIX + "/consultarpropietario/{id}")
    public Propietario consultarPorId(@PathVariable("id") int id) {
        return propietarioService.consultarPorId(id);
    }
    
    @GetMapping(value = PREFIX + "/consultarpropietarios")
    public Set<Propietario> consultarTodos() {
        return propietarioService.consultarTodos();
    }
}
