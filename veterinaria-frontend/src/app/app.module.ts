import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MedicoComponent } from './medico/medico.component';
import { HomeComponent } from './home/home.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MascotaComponent } from './mascota/mascota.component';
import { PropietarioComponent } from './propietario/propietario.component';
import { CitaComponent } from './cita/cita.component';
import { AutenticacionComponent } from './autenticacion/autenticacion.component';

@NgModule({
  declarations: [
    AppComponent,
    MedicoComponent,
    HomeComponent,
    MascotaComponent,
    PropietarioComponent,
    CitaComponent,
    AutenticacionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
