package com.example.pruebaconcepto.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaconcepto.model.Mascota;
import com.example.pruebaconcepto.services.MascotaService;

@CrossOrigin(origins = "*")
@RestController
public class MascotaController {
	
	@Autowired
    MascotaService mascotaService;

	private static final String PREFIX = "/veterinaria";

	@PostMapping(value = PREFIX + "/registrarmascota", consumes = "application/json", produces = "application/json")
	public int registrarMascota(@RequestBody Mascota mascota) {
		mascotaService.registrarMascota(mascota);
		return mascota.getId();
	}
	
    @GetMapping(value = PREFIX + "/consultarmascota/{id}")
    public Mascota consultarPorId(@PathVariable("id") int id) {
        return mascotaService.consultarPorId(id);
    }
    
    @GetMapping(value = PREFIX + "/consultarmascotas")
    public Set<Mascota> consultarTodos() {
        return mascotaService.consultarTodos();
    }
}
