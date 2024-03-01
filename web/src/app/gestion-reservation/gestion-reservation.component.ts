// reservations.component.ts
import { Component, OnInit } from '@angular/core';
import { GestionReservationService } from '../gestion-reservation.service';
import { ChangeDetectorRef } from '@angular/core';
@Component({
  selector: 'app-gestion-reservation',
  templateUrl: './gestion-reservation.component.html',
  styleUrl: './gestion-reservation.component.css',
})
export class GestionReservationComponent {
  reservations: any[] = [];
  index!: number;
  constructor(
    private cdr: ChangeDetectorRef,
    private gestionReservationService: GestionReservationService
  ) {}

  ngOnInit(): void {
    this.gestionReservationService.getAllReservations().subscribe((data) => {
      this.reservations = data;
      console.log(data);
      this.cdr.detectChanges();
    });
  }
  supprimerReservation(index: number, id: number) {
    // Appeler le service pour supprimer la réservation dans le backend
    this.gestionReservationService.supprimerReservation(id).subscribe(() => {
      // Supprimer la réservation de l'interface
      this.reservations.splice(index, 1);
    });
  }

  validerReservation(index: number, reservation: any) {
    // Marquer la réservation comme traitée et préparer les données à envoyer
    reservation.etat_demande = true;
    const reservationTraitee = { ...reservation, etat_demande: true };

    // Appeler le service pour envoyer la réservation traitée au backend
    this.gestionReservationService
      .validerReservation(reservationTraitee.id, reservationTraitee)
      .subscribe(() => {
        // Mise à jour de l'interface si nécessaire
        // Par exemple, enlever le bouton Supprimer ou afficher "Réservation traitée"
        this.reservations[index] = reservationTraitee;
        this.cdr.detectChanges();
      });
  }
}
