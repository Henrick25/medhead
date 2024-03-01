package com.medHeadReservation.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medHeadReservation.api.dto.ReservationDTO;
import com.medHeadReservation.api.model.Reservation;
import com.medHeadReservation.api.service.HospitalService;
import com.medHeadReservation.api.service.ReservationService;
import com.medHeadReservation.api.service.mail.EmailService;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private HospitalService HospitalService;

     @Autowired
    private EmailService emailService;

    @PostMapping("/api/web/reservation")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO savedReservationDTO = reservationService.saveReservation(reservationDTO);
        return ResponseEntity.ok(savedReservationDTO);
    }
      @GetMapping("/api/reservations/list")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
   //  @DeleteMapping("/{id}")
   // public ResponseEntity<?> supprimerReservation(@PathVariable Long id) {
        // Logique pour supprimer la réservation
     //   return ResponseEntity.ok().build();
    //}

    @PutMapping("/api/reservations/{id}")
    public ResponseEntity<Reservation> validerReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) throws IOException {
        // Logique pour valider et mettre à jour la réservation
        Reservation reservation = reservationService.updateEtatDemande(id,reservationDTO.getEtat_demande());
        HospitalService.decrementLit(reservationDTO.getHospitalId());
         emailService.sendSimpleMessage(reservation.getMail() , "Confirmation de réservation", "Votre réservation a été traitée et confirmée.");
        return ResponseEntity.ok(reservation);
    }
}
