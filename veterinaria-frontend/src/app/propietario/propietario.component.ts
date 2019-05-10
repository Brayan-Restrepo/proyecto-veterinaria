import { Component, OnInit } from '@angular/core';
import { PropietarioService } from '../servicios/propietario.service';

@Component({
  selector: 'app-propietario',
  templateUrl: './propietario.component.html',
  styleUrls: ['./propietario.component.css']
})
export class PropietarioComponent implements OnInit {

  formulario: any = {};
  propietarios = [];

  constructor(private propietarioService: PropietarioService) { }

  ngOnInit() {
    this.consultarPropietarios();
  }

  consultarPropietarios() {
    this.propietarioService.consultarPropietarios().then((response) => {
      this.propietarios = response;
    }).catch((error) => {
      console.log(error);
    });
  }

  enviar() {
    this.propietarioService.registrarPropietario(this.formulario).then((response) => {
      alert('Se registro correctamente!');
      location.reload();
    }).catch((error) => {
      console.log(error);
    });
  }

}
