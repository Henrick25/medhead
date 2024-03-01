package com.medhead.api.service;


import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.medhead.api.model.Hospital;
import com.medhead.api.repository.HospitalRepository;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HospitalServiceTest {

    @Mock
    private HospitalRepository hospitalRepository;

    @InjectMocks
    private HospitalService hospitalService;

    @Test
    public void testFindNearestHospital() {
        // Préparation
        String specialty = "Cardiology";
        double patientLatitude = 40.712776;
        double patientLongitude = -74.005974;
        Hospital expectedHospital = new Hospital();
        expectedHospital.setName("Best Hospital");
        expectedHospital.setLatitude(patientLatitude);
        expectedHospital.setLongitude(patientLongitude);
        
        when(hospitalRepository.find_nearest_hospital(specialty, patientLatitude, patientLongitude))
            .thenReturn(expectedHospital);

        // Action
        Hospital result = hospitalService.findNearestHospital(specialty, patientLatitude, patientLongitude);

        // Vérification
        assertNotNull(result, "L'hôpital trouvé ne devrait pas être null");
        assertEquals(expectedHospital.getName(), result.getName(), "Le nom de l'hôpital trouvé devrait correspondre à celui attendu");
        assertEquals(expectedHospital.getLatitude(), result.getLatitude(), "La latitude de l'hôpital trouvé devrait correspondre à celle attendue");
        assertEquals(expectedHospital.getLongitude(), result.getLongitude(), "La longitude de l'hôpital trouvé devrait correspondre à celle attendue");

        // Vérifiez que le repository a été appelé avec les bons paramètres
        verify(hospitalRepository).find_nearest_hospital(specialty, patientLatitude, patientLongitude);
    }
    
    @Test
    public void testFindNearestHospitalWhenNoHospitalFound() {
        // Préparation
        String specialty = "Cardiology";
        double patientLatitude = 40.712776;
        double patientLongitude = -74.005974;
        
        // Simuler que le repository retourne null lorsque aucun hôpital n'est trouvé
        when(hospitalRepository.find_nearest_hospital(specialty, patientLatitude, patientLongitude))
            .thenReturn(null);

        // Action
        Hospital result = hospitalService.findNearestHospital(specialty, patientLatitude, patientLongitude);

        // Vérification
        assertNull(result, "Aucun hôpital ne devrait être trouvé, et le résultat devrait être null");

        // Vérifiez que le repository a été appelé avec les bons paramètres
        verify(hospitalRepository).find_nearest_hospital(specialty, patientLatitude, patientLongitude);
    }
}

