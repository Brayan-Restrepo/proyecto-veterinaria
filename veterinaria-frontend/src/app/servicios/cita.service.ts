import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CitaService {

  constructor(private http: HttpClient) { }

  public registrarCita(data: any): Promise<any> {
    return this.http.post(`http://localhost:8080/veterinaria/registrarcita`, data, this.getOptions()).toPromise();
  }

  public consultarCitas(): Promise<any> {
    return this.http.get(`http://localhost:8080/veterinaria/consultarcitas`, this.getOptions()).toPromise();
  }

  private getOptions() {
    return { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  }
}
