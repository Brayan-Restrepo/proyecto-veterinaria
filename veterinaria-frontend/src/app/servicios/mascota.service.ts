import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MascotaService {

  constructor(private http: HttpClient) { }

  public registrarMascota(data: any): Promise<any> {
    return this.http.post(`http://localhost:8080/veterinaria/registrarmascota`, data, this.getOptions()).toPromise();
  }

  public consultarMascota(): Promise<any> {
    return this.http.get(`http://localhost:8080/veterinaria/consultarmascotas`, this.getOptions()).toPromise();
  }

  private getOptions() {
    return { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  }
}
