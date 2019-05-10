import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PropietarioService {

  constructor(private http: HttpClient) { }

  public registrarPropietario(data: any): Promise<any> {
    return this.http.post(`http://localhost:8080/veterinaria/registrarpropietario`, data, this.getOptions()).toPromise();
  }

  public consultarPropietarios(): Promise<any> {
    return this.http.get(`http://localhost:8080/veterinaria/consultarpropietarios`, this.getOptions()).toPromise();
  }

  private getOptions() {
    return { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  }
}
