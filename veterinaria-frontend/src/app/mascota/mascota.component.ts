import { Component, OnInit } from '@angular/core';
import { MascotaService } from '../servicios/mascota.service';

@Component({
  selector: 'app-mascota',
  templateUrl: './mascota.component.html',
  styleUrls: ['./mascota.component.css']
})
export class MascotaComponent implements OnInit {

  formulario: any = {};
  mascotas = [];

  constructor(private mascotaService: MascotaService) { }

  ngOnInit() {
    this.consultarMascotas();
  }

  consultarMascotas() {
    this.mascotaService.consultarMascota().then((response) => {
      this.mascotas = response;
    }).catch((error) => {
      console.log(error);
    });
  }

  enviar() {
    this.mascotaService.registrarMascota(this.formulario).then((response) => {
      alert('Se registro correctamente!');
      location.reload();
    }).catch((error) => {
      console.log(error);
    });
  }

}
