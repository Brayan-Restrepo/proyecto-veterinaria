package com.example.pruebaconcepto.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaconcepto.model.Medico;
import com.example.pruebaconcepto.services.MedicoService;

@CrossOrigin(origins = "*")
@RestController
public class MedicoController {

	private static final String PREFIX = "/veterinaria";
	
	@Autowired
    MedicoService medicoService;

	@PostMapping(value = PREFIX + "/registrarmedico", consumes = "application/json", produces = "application/json")
	public int registrarMedico(@RequestBody Medico medico) {
		medicoService.registrarMedico(medico);
		return medico.getId();
	}
	
    @GetMapping(value = PREFIX + "/consultarmedico/{id}")
    public Medico consultarPorId(@PathVariable("id") int id) {
        return medicoService.consultarPorId(id);
    }
    
    @GetMapping(value = PREFIX + "/consultarmedicos")
    public Set<Medico> consultarTodos() {
        return medicoService.consultarTodos();
    }

}
