import { Component } from '@angular/core';
import { HospitalService } from '../hospital.service';
import { Hospital } from '../models/hospital';

@Component({
  selector: 'app-search-hospital',
  templateUrl: './search-hospital.component.html',
  styleUrls: ['./search-hospital.component.css'],
})
export class SearchHospitalComponent {
  specialty = '';
  latitude!: number;
  longitude!: number;
  hospital: Hospital | null = null;
  lit!: number;
  notFound = false;
  erreurSaisi = '';

  showReservationForm = false;
  patientName = '';
  appointmentDate = '';

  reservationSuccess = false;

  constructor(private hospitalService: HospitalService) {
    this.getUserLocation();
  }

  searchHospital(): void {
    this.hospital = null;
    this.notFound = false;
    this.erreurSaisi = '';
    this.hospitalService
      .getNearestHospital(this.specialty, this.latitude, this.longitude)
      .subscribe({
        next: (hospital) => {
          if (hospital) {
            this.hospital = hospital;
            console.log(hospital);
            this.notFound = false;
          } else {
            this.erreurSaisi =
              'Aucun hôpital trouvé. Veuillez essayer avec d’autres critères.';
            this.notFound = true;
          }
        },
        error: (error) => {
          console.error('Error fetching the hospital:', error);
          this.notFound = true;
          this.erreurSaisi = error.error
            ? error.error
            : "Les urgences sont saturées, il n'y a actuellement plus de place disponible pour cette spécialité. Veuillez réitérer votre demande d'ici 30 minutes.";
        },
      });
  }
  submitReservation(): void {
    if (this.hospital) {
      const reservationDetails = {
        hospitalId: this.hospital.id, // Assurez-vous que `hospital` a un `id`
        patientName: this.patientName,
        appointmentDate: this.appointmentDate,
      };

      console.log('Détails de la réservation:', reservationDetails);
      this.reservationSuccess = true; // Mise à jour de l'état pour indiquer que la réservation est réussie
      this.lit -= 1;
      this.showReservationForm = false;
    } else {
      console.error('Aucun hôpital sélectionné pour la réservation');
    }
  }
  getUserLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        console.log(position);
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
      });
    } else {
      console.error('Geolocation is not supported by this browser.');
    }
  }
  handleReservationMade(success: boolean): void {
    if (success) {
      this.showReservationForm = false;
      // Vous pouvez également réinitialiser d'autres états au besoin
    }
  }
}
