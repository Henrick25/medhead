import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms'; // Importez FormsModule si vous utilisez des formulaires basés sur des templates
// import { ReactiveFormsModule } from '@angular/forms'; // Décommentez si vous utilisez des formulaires réactifs
import { ReservationFormComponent } from './reservation.component';

import { of, throwError } from 'rxjs';
import { ReservationService } from '../reservation.service';

describe('ReservationFormComponent', () => {
  let component: ReservationFormComponent;
  let fixture: ComponentFixture<ReservationFormComponent>;
  let reservationService: ReservationService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ReservationFormComponent],
      imports: [HttpClientTestingModule, FormsModule],
      providers: [ReservationService],
    }).compileComponents();

    fixture = TestBed.createComponent(ReservationFormComponent);
    component = fixture.componentInstance;
    reservationService = TestBed.inject(ReservationService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('submitReservation should call reservationService and emit event on success', () => {
    const mockResponse = {}; // Adaptez en fonction de ce que votre API retourne
    spyOn(reservationService, 'submitReservation').and.returnValue(
      of(mockResponse)
    );
    spyOn(component.reservationMade, 'emit');

    component.submitReservation();

    expect(reservationService.submitReservation).toHaveBeenCalled();
    expect(component.reservationMade.emit).toHaveBeenCalledWith(true);
  });

  it('submitReservation should handle error', () => {
    spyOn(reservationService, 'submitReservation').and.returnValue(
      throwError(() => new Error('Test Error'))
    );
    spyOn(console, 'error');

    component.submitReservation();

    expect(reservationService.submitReservation).toHaveBeenCalled();
    expect(console.error).toHaveBeenCalledWith(
      'Erreur lors de la réservation:',
      jasmine.any(Error)
    );
  });
});
