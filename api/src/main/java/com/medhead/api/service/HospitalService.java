package com.medhead.api.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.api.model.Hospital;
import com.medhead.api.repository.HospitalRepository;

import jakarta.transaction.Transactional;
@Service
public class HospitalService {
	@Autowired
    private HospitalRepository hospitalRepository;
	
	@Transactional
    public Hospital findNearestHospital(String specialty, double patientLatitude, double patientLongitude) {
       
    	
    	Hospital hospitals = hospitalRepository.find_nearest_hospital(specialty ,patientLatitude,patientLongitude  );
        return hospitals;
        
        
      
    }

	
    public List <Hospital> findAllHospital() {
        // Implémentez la logique pour trouver l'hôpital le plus proche avec la spécialité requise.
        // Ceci est un exemple simplifié.
    	List<Hospital> hospitals = hospitalRepository.findAll();
   
        return hospitals;
    }
}
