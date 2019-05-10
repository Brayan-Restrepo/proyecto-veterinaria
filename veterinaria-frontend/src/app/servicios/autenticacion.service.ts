import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  constructor(private http: HttpClient) { }

  public validarUsuario(user: string, pass: string): Promise<any> {
    return this.http.get(`http://localhost:8080/veterinaria/consultarusuario/${user}/${pass}`, this.getOptions()).toPromise();
  }

  public registrarUsuario(data: any): Promise<any> {
    return this.http.post(`http://localhost:8080/veterinaria/registrarusuario`, data, this.getOptions()).toPromise();
  }

  private getOptions() {
    return { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  }
}
