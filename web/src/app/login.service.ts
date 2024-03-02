// auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenModel } from './models/token';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private loginUrl = 'api/reservations/token'; // URL vers votre API de connexion

  constructor(private http: HttpClient) {}

  login(
    username: string | null,
    password: string | null
  ): Observable<TokenModel> {
    const headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(username + ':' + password),
      'Content-Type': 'application/json',
    });
    return this.http.get<TokenModel>(this.loginUrl, { headers: headers });
  }
}
