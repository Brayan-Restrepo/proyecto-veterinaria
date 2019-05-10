import { Component, OnInit } from '@angular/core';
import { AutenticacionService } from '../servicios/autenticacion.service';
import { Alert } from 'selenium-webdriver';
import { Router } from '@angular/router';

@Component({
  selector: 'app-autenticacion',
  templateUrl: './autenticacion.component.html',
  styleUrls: ['./autenticacion.component.css']
})
export class AutenticacionComponent implements OnInit {

  formulario: any = {};
  registro: any = {};
  isFormulario = false;
  
  constructor(
    private autenticacionService: AutenticacionService,
    private router: Router) { }

  ngOnInit() {
  }

  validar() {
    this.autenticacionService.validarUsuario(this.formulario.user, this.formulario.pass).then((response) => {
      if (response) {
        this.router.navigate(['home']);
      } else {
        alert('Debe registrarse');
      }
    }).catch((error) => {
      console.log(error);
    });
  }

  mostrarFormulario() {
    this.isFormulario = true;
  }

  registrarse() {
    this.autenticacionService.registrarUsuario(this.registro).then((response) => {
      if(response) {
        alert('Se registro correctamente!');
        location.reload();
      } else {
        alert('Error en el registro!');
      }
    }).catch((error) => {
      console.log(error);
    });
  }

}
