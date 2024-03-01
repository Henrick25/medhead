package com.medHeadReservation.api.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.medHeadReservation.api.dto.ReservationDTO;
import com.medHeadReservation.api.mapper.ReservationMapper;
import com.medHeadReservation.api.model.Reservation;
import com.medHeadReservation.api.repository.ReservationRepository;
import com.medHeadReservation.api.service.ReservationService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    public void saveReservationTest() {
        // Préparation des données d'entrée
        ReservationDTO inputDto = new ReservationDTO();
        // Configuration inputDto 
        inputDto.setHospitalId(1L);
        inputDto.setPatientName("John Doe");
       

        Reservation reservation = ReservationMapper.toEntity(inputDto);
        Reservation savedReservation = new Reservation();
        
        savedReservation.setId(1L); 

        // Configuration du comportement du mock
        when(reservationRepository.save(any(Reservation.class))).thenReturn(savedReservation);

        // Action : Appel de la méthode à tester
        ReservationDTO resultDto = reservationService.saveReservation(inputDto);

        // Vérification : Le repository est appelé avec la bonne entité
        verify(reservationRepository).save(any(Reservation.class));

        // Assertions supplémentaires pour vérifier le DTO retourné
        assertEquals(savedReservation.getId(), resultDto.getId());
    }
    
    @Test
    public void getAllReservationsTest() {
        // Préparation des données simulées
        Reservation reservation1 = new Reservation(); // Configurez reservation1
        Reservation reservation2 = new Reservation(); // Configurez reservation2
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2);

        when(reservationRepository.findAll()).thenReturn(reservations);

        // Action : Appel de la méthode à tester
        List<ReservationDTO> resultDTOs = reservationService.getAllReservations();

        // Vérification : Assurez-vous que la liste de DTOs correspond aux entités
        assertEquals(reservations.size(), resultDTOs.size());
        
        // Pour une vérification plus approfondie, vous pouvez vérifier les champs individuels si nécessaire
        List<ReservationDTO> expectedDTOs = reservations.stream()
                                                         .map(ReservationMapper::toDTO)
                                                         .collect(Collectors.toList());
        for (int i = 0; i < reservations.size(); i++) {
            assertEquals(expectedDTOs.get(i).getId(), resultDTOs.get(i).getId());
            // Répétez pour les autres champs si nécessaire
        }
    }
    
    @Test
    public void updateEtatDemandeTest() {
        Long reservationId = 1L;
        Boolean nouvelEtat = true;
        Reservation reservation = new Reservation();
        reservation.setId(reservationId);
        reservation.setEtat_demande(!nouvelEtat); // État initial différent pour vérifier la mise à jour

        when(reservationRepository.findById(reservationId)).thenReturn(java.util.Optional.of(reservation));
        when(reservationRepository.save(any(Reservation.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Action : Mise à jour de l'état de la demande
        Reservation updatedReservation = reservationService.updateEtatDemande(reservationId, nouvelEtat);

        // Vérification : L'état de la demande a été mis à jour
        assertEquals(nouvelEtat, updatedReservation.getEtat_demande());
        verify(reservationRepository).save(updatedReservation); // Vérifie que la réservation est sauvegardée

        // Vérification supplémentaire pour s'assurer que la méthode save est appelée avec une réservation dont l'état de demande a été mis à jour
        verify(reservationRepository).save(argThat(reservationArg -> 
            reservationArg.getId().equals(reservationId) && 
            reservationArg.getEtat_demande().equals(nouvelEtat)));
    }
}
