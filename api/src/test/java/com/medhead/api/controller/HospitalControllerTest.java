package com.medhead.api.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.medhead.api.model.Hospital;
import com.medhead.api.service.HospitalService;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest
public class HospitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalService hospitalService;

  


    @Test
    @WithMockUser(username="user", password="user", roles="USER")
    public void getNearestHospital_ReturnsNotFoundWhenNoHospital() throws Exception {
        // Configurez le mock pour simuler l'absence d'hôpital
        Mockito.when(hospitalService.findNearestHospital(Mockito.anyString(), Mockito.anyDouble(), Mockito.anyDouble()))
                .thenReturn(null);

        mockMvc.perform(get("/api/hospital")
                .param("specialty", "Cardiologie")
                .param("latitude", "45.5017")
                .param("longitude", "-73.5673") // Inclure l'authentification
                .contentType("application/json"))
                .andExpect(status().isNotFound()); // S'attendre à un 404
    }
    
    @Test
    @WithMockUser(username="user", password="user", roles="USER")
    public void getNearestHospital_ReturnsHospitalSuccessfully() throws Exception {
        // Simuler un hôpital trouvé
        Hospital hospital = new Hospital();
        hospital.setName("Hôpital Général");
        hospital.setLatitude(45.5017);
        hospital.setLongitude(-73.5673);
        // Ajoutez d'autres propriétés nécessaires au mock de l'hôpital

        Mockito.when(hospitalService.findNearestHospital(Mockito.anyString(), Mockito.anyDouble(), Mockito.anyDouble()))
                .thenReturn(hospital);

        mockMvc.perform(get("/api/hospital")
                .param("specialty", "Cardiologie")
                .param("latitude", "45.5017")
                .param("longitude", "-73.5673")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Vérifier que le statut est 200 OK
                .andExpect(jsonPath("$.name").value("Hôpital Général")); // Exemple de vérification de contenu
        // Vous pouvez ajouter plus de vérifications ici selon le contenu attendu
    }

}
