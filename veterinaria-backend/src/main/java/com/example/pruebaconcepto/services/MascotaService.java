package com.example.pruebaconcepto.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaconcepto.model.Mascota;
import com.example.pruebaconcepto.repositories.MascotaRepository;

@Service
public class MascotaService {

	@Autowired
	MascotaRepository mascotaRepository;
	
	public void registrarMascota(Mascota mascota) {
		mascotaRepository.save(mascota);
	}

	public Mascota consultarPorId(int id) {
		return mascotaRepository.findById(id).get();
	}

	public Set<Mascota> consultarTodos() {
		Set<Mascota> mascotas = new HashSet<Mascota>();
		mascotaRepository.findAll().forEach(mascota -> mascotas.add(mascota));
		return mapper(mascotas);
	}

	public Set<Mascota> mapper(Set<Mascota> mascotas) {
		Set<Mascota> rs = new HashSet<>();
		for (Mascota c : mascotas) {
			Mascota c2 = mapper(c);
			rs.add(c2);
		}
		return rs;
	}

	public Mascota mapper(Mascota c) {
		Mascota c2 = new Mascota();
		c2.setId(c.getId());
		c2.setEspecie(c.getEspecie());
		c2.setNombre(c.getNombre());
		c2.setEdad(c.getEdad());
		c2.setPeso(c.getPeso());
		c2.setRaza(c.getRaza());
		return c2;
	}
}
