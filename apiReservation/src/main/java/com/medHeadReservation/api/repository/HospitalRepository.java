package com.medHeadReservation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.medHeadReservation.api.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>  {
	
}
