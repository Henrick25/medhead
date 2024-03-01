package com.medHeadReservation.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medHeadReservation.api.model.Hospital;
import com.medHeadReservation.api.repository.HospitalRepository;
import jakarta.persistence.EntityNotFoundException;
@Service
public class HospitalService {
	 @Autowired
	    private HospitalRepository hospitalRepository;

	    public void decrementLit(Long hospitalId) {
			Hospital hospital = hospitalRepository.findById(hospitalId).orElseThrow(() -> new EntityNotFoundException("Reservation non trouvée avec l'id: " + hospitalId));
		Long lit= 	hospital.getLit();
		hospital.setLit(lit);
		hospitalRepository.save(hospital);
	    }
}
