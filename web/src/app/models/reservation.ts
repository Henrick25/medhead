export interface Reservation {
  id?: number; // Identifiant unique pour la réservation
  hospitalId: string; // Identifiant de l'hôpital où la réservation est faite
  patientId?: string; // Identifiant du patient pour qui la réservation est faite
  specialty: string; // Spécialité médicale concernée, si applicable
  appointmentDate: Date | string; // Date et heure du rendez-vous ou de l'admission
  status: 'confirmed' | 'pending' | 'cancelled'; // Statut de la réservation
  reason?: string; // Motif de la consultation ou de l'hospitalisation (optionnel)
}
