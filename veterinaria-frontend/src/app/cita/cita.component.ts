import { Component, OnInit } from '@angular/core';
import { CitaService } from '../servicios/cita.service';
import { MascotaService } from '../servicios/mascota.service';
import { MedicoService } from '../servicios/medico.service';
import { PropietarioService } from '../servicios/propietario.service';

@Component({
  selector: 'app-cita',
  templateUrl: './cita.component.html',
  styleUrls: ['./cita.component.css']
})
export class CitaComponent implements OnInit {
  
  formulario: any = {};
  citas = [];
  medicos = [];
  propietarios = [];
  mascotas = [];

  constructor(
    private citaService: CitaService,
    private mascotaService: MascotaService,
    private medicoService: MedicoService,
    private propietarioService: PropietarioService,
    ) { }

  ngOnInit() {
    this.consultarMascotas();
    this.consultarPropietarios();
    this.consultarMedicos();
    this.consultarCitas();
  }

  consultarMascotas() {
    this.mascotaService.consultarMascota().then((response) => {
      this.mascotas = response;
    }).catch((error) => {
      console.log(error);
    });
  }

  consultarPropietarios() {
    this.propietarioService.consultarPropietarios().then((response) => {
      this.propietarios = response;
    }).catch((error) => {
      console.log(error);
    });
  }

  consultarMedicos() {
    this.medicoService.consultarMedicos().then((response) => {
      this.medicos = response;
    }).catch((error) => {
      console.log(error);
    });
  }

  consultarCitas() {
    this.citaService.consultarCitas().then((response) => {
      this.citas = response;
    }).catch((error) => {
      console.log(error);
    });
  }

  enviar() {
    this.citaService.registrarCita(this.formulario).then((response) => {
      alert('Se registro correctamente!');
      location.reload();
    }).catch((error) => {
      console.log(error);
    });
  }
}
