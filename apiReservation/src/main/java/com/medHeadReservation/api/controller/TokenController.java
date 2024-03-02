package com.medHeadReservation.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.medHeadReservation.api.dto.TokenDTO;
import com.medHeadReservation.api.service.JWTService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("api/reservations")
public class TokenController {

	
		private JWTService jwtservice;
	

	  public TokenController(JWTService jwtservice) {
			super();
			this.jwtservice = jwtservice;
		}


	@GetMapping(value = "token")
	    public ResponseEntity<TokenDTO> generateToken() {


		  
	        return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO(jwtservice.generateToken()));
	    }


	public JWTService getJwtservice() {
		return jwtservice;
	}


	public void setJwtservice(JWTService jwtservice) {
		this.jwtservice = jwtservice;
	}
	
}
