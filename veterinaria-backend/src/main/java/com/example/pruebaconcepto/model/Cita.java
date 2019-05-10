package com.example.pruebaconcepto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cita")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=999999999)
public class Cita {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private int id;
	@Column(name = "mascota")
	private String mascota;
	@Column(name = "propietario")
	private String propietario;
	@Column(name = "observaciones")
	private String observaciones;
	@Column(name = "fechacita")
	private Date fechacita;
	@Column(name = "medico")
	private String medico;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMascota() {
		return mascota;
	}
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFechacita() {
		return fechacita;
	}
	public void setFechacita(Date fechacita) {
		this.fechacita = fechacita;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
}
