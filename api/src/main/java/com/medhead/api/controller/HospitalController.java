package com.medhead.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.api.dto.HospitalDTO;
import com.medhead.api.mapper.HospitalMapper;
import com.medhead.api.model.Hospital;
import com.medhead.api.service.HospitalService;

@RestController
public class HospitalController {
	  @Autowired
	    private HospitalService hospitalService;
	  
	
	  public HospitalController(HospitalService hospitalService) {
	        this.hospitalService = hospitalService;
	    }
	  @GetMapping("/api/hospital")
	    public ResponseEntity<?> getNearestHospital(@RequestParam String specialty, @RequestParam("latitude") double latitude,
	                                                @RequestParam("longitude") double longitude) {
	        try {
	            Hospital hospital = hospitalService.findNearestHospital(specialty, latitude, longitude);
	            if (hospital == null) {
	                return new ResponseEntity<>("Les urgences sont saturées, il n'y a actuellement plus de place disponible pour cette spécialité. Veuillez réitérer votre demande d'ici 30 minutes.", HttpStatus.NOT_FOUND);
	            }

	            // Conversion de l'entité Hospital en HospitalDTO
	            HospitalDTO hospitalDTO = HospitalDTO.convertToDTO(hospital); // Cette méthode doit être implémentée

	            return new ResponseEntity<>(hospitalDTO, HttpStatus.OK);
	        } catch (Exception e) {
	            // Gérer l'exception ou logger l'erreur
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	  
}
