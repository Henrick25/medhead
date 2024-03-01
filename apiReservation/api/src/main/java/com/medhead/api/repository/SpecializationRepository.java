package com.medhead.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medhead.api.model.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

}
