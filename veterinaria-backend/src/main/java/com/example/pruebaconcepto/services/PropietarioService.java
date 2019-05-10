package com.example.pruebaconcepto.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaconcepto.model.Propietario;
import com.example.pruebaconcepto.repositories.PropietarioRepository;

@Service
public class PropietarioService {

	@Autowired
	PropietarioRepository propietarioRepository;

	public void registrarPropietario(Propietario propietario) {
		propietarioRepository.save(propietario);
	}

	public Propietario consultarPorId(int id) {
		return propietarioRepository.findById(id).get();
	}

	public Set<Propietario> consultarTodos() {
		Set<Propietario> propietarios = new HashSet<Propietario>();
		propietarioRepository.findAll().forEach(propietario -> propietarios.add(propietario));
		return mapper(propietarios);
		
	}

	public Set<Propietario> mapper(Set<Propietario> propietarios) {
		Set<Propietario> rs = new HashSet<>();
		for (Propietario c : propietarios) {
			Propietario c2 = mapper(c);
			rs.add(c2);
		}
		return rs;
	}

	public Propietario mapper(Propietario c) {
		Propietario c2 = new Propietario();
		c2.setId(c.getId());
		c2.setNombres(c.getNombres());
		c2.setApellidos(c.getApellidos());
		c2.setDocumentoIdentificacion(c.getDocumentoIdentificacion());
		return c2;
	}
}
