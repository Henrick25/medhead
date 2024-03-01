package com.medHeadReservation.api.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medHeadReservation.api.controller.ReservationController;
import com.medHeadReservation.api.dto.ReservationDTO;
import com.medHeadReservation.api.model.Reservation;
import com.medHeadReservation.api.service.HospitalService;
import com.medHeadReservation.api.service.ReservationService;
import com.medHeadReservation.api.service.mail.EmailService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class ReservationControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Mock
    private HospitalService hospitalService;

    @Mock
    private EmailService emailService;
    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    @BeforeEach
    public void setup() {
        // Initialisation de MockMvc avec le contrôleur injecté de mocks
        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @Test
    public void createReservationTest() throws Exception {
        // Préparation de la donnée de test
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setHospitalId(1L);
        reservationDTO.setPatientName("John Doe");
        reservationDTO.setPatientPhone("1234567890");
        reservationDTO.setMail("johndoe@example.com");
        reservationDTO.setAge(25);
        reservationDTO.setSexe("M");
        reservationDTO.setHeure("09:00");
        reservationDTO.setEtat("PENDING");
        reservationDTO.setEtat_demande(Boolean.TRUE);

        // Configuration du service mocké pour retourner le DTO lors de l'appel
        given(reservationService.saveReservation(any(ReservationDTO.class))).willReturn(reservationDTO);

        // Exécution du test et vérification des résultats
        mockMvc.perform(post("/api/web/reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservationDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(reservationDTO)));
        System.out.println(reservationDTO.getPatientName());
    }
    
    @Test
    public void getAllReservationsTest() throws Exception {
        // Préparation des données de test
        ReservationDTO reservationDTO1 = new ReservationDTO(); // Configurez vos objets comme nécessaire
        ReservationDTO reservationDTO2 = new ReservationDTO();
        List<ReservationDTO> reservationList = Arrays.asList(reservationDTO1, reservationDTO2);

        // Configuration du comportement du mock
        given(reservationService.getAllReservations()).willReturn(reservationList);

        // Exécution du test
        mockMvc.perform(get("/api/reservations/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))); // Vérifie que la liste contient bien 2 éléments
    }

    @Test
    public void validerReservationTest() throws Exception {
        Long id = 1L;
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setHospitalId(1L);
        reservationDTO.setMail("user@example.com");
        reservationDTO.setEtat_demande(true);

        Reservation reservation = new Reservation();
        reservation.setMail("user@example.com");//email

        given(reservationService.updateEtatDemande(eq(id), eq(true))).willReturn(reservation);

        mockMvc.perform(put("/api/reservations/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reservationDTO)))
                .andExpect(status().isOk());

        verify(reservationService).updateEtatDemande(eq(id), eq(reservationDTO.getEtat_demande()));
        verify(hospitalService).decrementLit(eq(reservationDTO.getHospitalId()));
        verify(emailService).sendSimpleMessage(eq("user@example.com"), anyString(), anyString()); // Vérifiez que l'e-mail est correct
    }
}

