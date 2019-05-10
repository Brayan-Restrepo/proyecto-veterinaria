package com.example.pruebaconcepto.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaconcepto.model.Cita;
import com.example.pruebaconcepto.services.CitaService;

@CrossOrigin(origins = "*")
@RestController
public class CitaController {
	
	@Autowired
    CitaService citaService;

	private static final String PREFIX = "/veterinaria";

	@PostMapping(value = PREFIX + "/registrarcita", consumes = "application/json", produces = "application/json")
	public int registrarCita(@RequestBody Cita cita) {
		citaService.registrarCita(cita);
		return cita.getId();
	}
	
    @GetMapping(value = PREFIX + "/consultarcita/{id}")
    public Cita consultarPorId(@PathVariable("id") int id) {
        return citaService.consultarPorId(id);
    }
    
    @GetMapping(value = PREFIX + "/consultarcitas")
    public Set<Cita> consultarTodos() {
        return citaService.consultarTodos();
    }
}
