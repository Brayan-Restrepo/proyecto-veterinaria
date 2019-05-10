package com.example.pruebaconcepto.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaconcepto.model.Medico;
import com.example.pruebaconcepto.repositories.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	MedicoRepository medicoRepository;

	public void registrarMedico(Medico medico) {
		medicoRepository.save(medico);
	}

	public Medico consultarPorId(int id) {
		return medicoRepository.findById(id).get();
	}

	public Set<Medico> consultarTodos() {
		Set<Medico> medicos = new HashSet<Medico>();
		medicoRepository.findAll().forEach(medico -> medicos.add(medico));
		return mapper(medicos);
		
	}

	public Set<Medico> mapper(Set<Medico> medicos) {
		Set<Medico> rs = new HashSet<>();
		for (Medico c : medicos) {
			Medico c2 = mapper(c);
			rs.add(c2);
		}
		return rs;
	}

	public Medico mapper(Medico c) {
		Medico c2 = new Medico();
		c2.setId(c.getId());
		c2.setNombres(c.getNombres());
		c2.setApellido1(c.getApellido1());
		c2.setApellido2(c.getApellido2());
		c2.setFechaNacimiento(c.getFechaNacimiento());
		return c2;
	}
}
