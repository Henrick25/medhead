import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hospital } from './models/hospital'; // Assurez-vous de définir l'interface Hospital selon la réponse de l'API
import { GooglePlaceModule } from 'ngx-google-places-autocomplete';
@Injectable({
  providedIn: 'root',
})
export class HospitalService {
  public apiUrl = '/api/hospital';
  hospital!: Hospital;
  constructor(private http: HttpClient) {}

  getNearestHospital(
    specialty: string,
    latitude: number,
    longitude: number
  ): Observable<Hospital> {
    let params = new HttpParams()
      .set('specialty', specialty)
      .set('latitude', latitude.toString())
      .set('longitude', longitude.toString());

    return this.http.get<Hospital>(`${this.apiUrl}`, { params });
  }
  getHospitalData(hospitalId?: string): Observable<Hospital> {
    // Si un ID d'hôpital est fourni, utilisez-le pour obtenir des détails spécifiques
    // Sinon, retournez les détails de l'hôpital par défaut ou actuellement sélectionné
    const endpoint = hospitalId
      ? `${this.apiUrl}/${hospitalId}`
      : `${this.apiUrl}/current`;
    return this.http.get<Hospital>(endpoint);
  }
}
