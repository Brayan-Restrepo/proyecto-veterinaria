package com.example.pruebaconcepto.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaconcepto.model.Autenticacion;
import com.example.pruebaconcepto.repositories.AutenticacionRepository;

@Service
public class AutenticacionService {

	@Autowired
	AutenticacionRepository autenticacionRepository;

	public boolean consultarUsuario(String user, String pass) {
		Set<Autenticacion> autenticaciones = new HashSet<Autenticacion>();
		autenticacionRepository.findAll().forEach(autenticacion -> autenticaciones.add(autenticacion));
		if(autenticaciones.isEmpty()) {
			return false;
		}
		
		for (Autenticacion aut : autenticaciones) {
			String user1 = aut.getUser().toString();
			String pass1 = aut.getPass().toString();
			if(user1.equals(user) && pass1.equals(pass)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void registrarUsuario(Autenticacion autenticacion) {
		autenticacionRepository.save(autenticacion);
	}

}
