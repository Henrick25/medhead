import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { GestionReservationService } from './gestion-reservation.service';

describe('GestionReservationService', () => {
  let service: GestionReservationService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [GestionReservationService],
    });
    service = TestBed.inject(GestionReservationService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify(); // Assurez-vous qu'il n'y a pas de requêtes en attente
  });

  it('getAllReservations should return a list of reservations', () => {
    const mockReservations = [
      { id: 1, name: 'Test Reservation' },
      { id: 2, name: 'Another Reservation' },
    ];

    service.getAllReservations().subscribe((reservations) => {
      expect(reservations.length).toBe(2);
      expect(reservations).toEqual(mockReservations);
    });

    const req = httpTestingController.expectOne(`${service.apiUrl}/list`);
    expect(req.request.method).toEqual('GET');
    req.flush(mockReservations);
  });

  it('supprimerReservation should delete a reservation', () => {
    const reservationId = 1;

    service.supprimerReservation(reservationId).subscribe((response) => {
      expect(response).toBeNull();
    });

    const req = httpTestingController.expectOne(
      `${service.apiUrl}/${reservationId}`
    );
    expect(req.request.method).toEqual('DELETE');
    req.flush(null); // Simuler une réponse vide pour DELETE
  });

  it('validerReservation should update reservation status', () => {
    const reservationId = 1;
    const updatedReservation = { id: reservationId, etat_demande: true };

    service
      .validerReservation(reservationId, updatedReservation)
      .subscribe((response) => {
        expect(response).toEqual(updatedReservation);
      });

    const req = httpTestingController.expectOne(
      `${service.apiUrl}/${reservationId}`
    );
    expect(req.request.method).toEqual('PUT');
    expect(req.request.body).toEqual(updatedReservation);
    req.flush(updatedReservation);
  });
});
