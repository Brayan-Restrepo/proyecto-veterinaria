import { Component, OnInit } from '@angular/core';
import { MedicoService } from '../servicios/medico.service';

@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.css']
})
export class MedicoComponent implements OnInit {

  formulario: any = {};
  medicos = [];

  constructor(private medicoService: MedicoService) { }

  ngOnInit() {
    this.consultarMedicos();
  }

  consultarMedicos() {
    this.medicoService.consultarMedicos().then((response) => {
      this.medicos = response;
    }).catch((error) => {
      console.log(error);
    });
  }

  enviar() {
    this.medicoService.registrarMedico(this.formulario).then((response) => {
      alert('Se registro correctamente!');
      location.reload();
    }).catch((error) => {
      console.log(error);
    });
  }

}
