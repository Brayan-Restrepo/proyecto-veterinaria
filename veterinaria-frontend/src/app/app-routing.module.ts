import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MedicoComponent } from '../app/medico/medico.component';
import { HomeComponent } from './home/home.component';
import { MascotaComponent } from './mascota/mascota.component';
import { PropietarioComponent } from './propietario/propietario.component';
import { CitaComponent } from './cita/cita.component';
import { AutenticacionComponent } from './autenticacion/autenticacion.component';

const routes: Routes = [
  { path: '', component: AutenticacionComponent },
  { path: '', redirectTo: '/autenticacion', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'medico', component: MedicoComponent },
  { path: 'mascota', component: MascotaComponent },
  { path: 'propietario', component: PropietarioComponent },
  { path: 'cita', component: CitaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
