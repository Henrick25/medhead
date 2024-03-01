package com.medHeadReservation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medHeadReservation.api.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
