import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from './models/reservation';
import { Patient } from './models/patient';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private apiUrl = '/api/web';

  constructor(private http: HttpClient) {}

  submitReservation(reservationDetails: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/reservation`, reservationDetails);
  }
}
