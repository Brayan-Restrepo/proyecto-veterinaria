package com.example.pruebaconcepto.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaconcepto.model.Cita;
import com.example.pruebaconcepto.repositories.CitaRepository;

@Service
public class CitaService {
	
	@Autowired
	CitaRepository citaRepository;
	
	public void registrarCita(Cita cita) {
		citaRepository.save(cita);
	}

	public Cita consultarPorId(int id) {
		return citaRepository.findById(id).get();
	}

	public Set<Cita> consultarTodos() {
		Set<Cita> citas = new HashSet<Cita>();
		citaRepository.findAll().forEach(cita -> citas.add(cita));
		return mapper(citas);
	}

	public Set<Cita> mapper(Set<Cita> citas) {
		Set<Cita> rs = new HashSet<>();
		for (Cita c : citas) {
			Cita c2 = mapper(c);
			rs.add(c2);
		}
		return rs;
	}

	public Cita mapper(Cita c) {
		Cita c2 = new Cita();
		c2.setId(c.getId());
		c2.setMascota(c.getMascota());
		c2.setMedico(c.getMedico());
		c2.setPropietario(c.getPropietario());
		c2.setObservaciones(c.getObservaciones());
		c2.setFechacita(c.getFechacita());
		return c2;
	}
	

}
