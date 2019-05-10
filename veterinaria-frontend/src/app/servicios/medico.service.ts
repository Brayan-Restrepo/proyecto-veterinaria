import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  constructor(private http: HttpClient) { }

  public registrarMedico(data: any): Promise<any> {
    return this.http.post(`http://localhost:8080/veterinaria/registrarmedico`, data, this.getOptions()).toPromise();
  }

  public consultarMedicos(): Promise<any> {
    return this.http.get(`http://localhost:8080/veterinaria/consultarmedicos`, this.getOptions()).toPromise();
  }

  private getOptions() {
    return { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  }
}
