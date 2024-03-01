import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms'; // Importez si des formulaires basés sur des templates sont utilisés
// import { ReactiveFormsModule } from '@angular/forms'; // Importez si des formulaires réactifs sont utilisés
import { GestionReservationComponent } from './gestion-reservation.component';
import { GestionReservationService } from '../gestion-reservation.service';
import { of } from 'rxjs';
describe('GestionReservationComponent', () => {
  let component: GestionReservationComponent;
  let fixture: ComponentFixture<GestionReservationComponent>;
  let service: GestionReservationService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GestionReservationComponent],
      imports: [HttpClientTestingModule, FormsModule],
      providers: [GestionReservationService],
    }).compileComponents();

    fixture = TestBed.createComponent(GestionReservationComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(GestionReservationService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should load reservations on init', () => {
    const mockReservations = [{ id: 1, name: 'Test Reservation' }];
    spyOn(service, 'getAllReservations').and.returnValue(of(mockReservations));

    component.ngOnInit();

    expect(service.getAllReservations).toHaveBeenCalled();
    expect(component.reservations).toEqual(mockReservations);
  });

  it('should delete a reservation', () => {
    const mockReservations = [{ id: 1, name: 'Test Reservation' }];
    component.reservations = [...mockReservations];
    spyOn(service, 'supprimerReservation').and.returnValue(of({}));

    component.supprimerReservation(0, 1);

    expect(service.supprimerReservation).toHaveBeenCalledWith(1);
    expect(component.reservations.length).toBe(0);
  });

  it('should validate a reservation', () => {
    const mockReservations = [
      { id: 1, name: 'Test Reservation', etat_demande: false },
    ];
    component.reservations = [...mockReservations];
    const updatedReservation = { ...mockReservations[0], etat_demande: true };
    spyOn(service, 'validerReservation').and.returnValue(
      of(updatedReservation)
    );

    component.validerReservation(0, mockReservations[0]);

    expect(service.validerReservation).toHaveBeenCalledWith(
      1,
      updatedReservation
    );
    // Assurez-vous que la réservation mise à jour a l'état_demande à true
    expect(component.reservations[0].etat_demande).toBeTrue();
  });
});
