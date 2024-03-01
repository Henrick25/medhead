import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl,
} from '@angular/forms';
import { ReservationService } from '../reservation.service';
import { HospitalService } from '../hospital.service'; // Si vous avez un service pour les hôpitaux
import { Hospital } from '../models/hospital';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationFormComponent {
  @Output() reservationMade = new EventEmitter<boolean>();
  @Input() hospitalId!: number; // Assurez-vous de passer cet ID depuis le composant parent
  patientName = '';
  patientPhone!: number;
  etat = '';
  mail = '';
  age!: number;
  sexe = '';
  heure = '';
  etat_demande = false;

  constructor(private reservationService: ReservationService) {}

  submitReservation(): void {
    const reservationDetails = {
      hospitalId: this.hospitalId,
      patientName: this.patientName,
      patientPhone: this.patientPhone,
      etat: this.etat,
      mail: this.mail,
      age: this.age,
      sexe: this.sexe,
      heure: this.heure,
      etat_demande: this.etat_demande,
      // Ajoutez ici tous les autres champs nécessaires
    };

    this.reservationService.submitReservation(reservationDetails).subscribe({
      next: (response) => {
        console.log('Réservation réussie:', response);
        console.log(reservationDetails);
        this.reservationMade.emit(true);
        // Traitez ici le succès de la soumission
      },
      error: (error) => {
        console.error('Erreur lors de la réservation:', error);
        // Traitez ici les erreurs
        console.log(reservationDetails);
      },
    });
  }
}
