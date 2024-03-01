import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { ReservationService } from './reservation.service';

describe('ReservationService', () => {
  let service: ReservationService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ReservationService],
    });

    service = TestBed.inject(ReservationService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify(); // S'assure qu'il n'y a pas de requêtes en attente
  });

  it('submitReservation should make a POST request and return expected data', () => {
    const testReservationDetails = {
      patient: 'John Doe',
      date: '2024-02-28',
      time: '14:00',
      type: 'Consultation',
    }; // Exemple de données de réservation

    const expectedResponse = {
      success: true,
      message: 'Reservation submitted successfully',
    }; // Réponse attendue de l'API

    service.submitReservation(testReservationDetails).subscribe((response) => {
      expect(response).toEqual(expectedResponse);
    });

    const req = httpTestingController.expectOne('/api/web/reservation');
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(testReservationDetails);

    req.flush(expectedResponse); // Simule une réponse de l'API
  });
});
