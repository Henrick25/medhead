package com.medhead.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medhead.api.model.Hospital;

import jakarta.transaction.Transactional;
@Transactional
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
	

	

    @Procedure(name = "find_nearest_hospital")
    Hospital find_nearest_hospital(@Param("specialisationName") String specialisationName, 
                                        @Param("lat") double lat, 
                                        @Param("lon") double lon);
}
