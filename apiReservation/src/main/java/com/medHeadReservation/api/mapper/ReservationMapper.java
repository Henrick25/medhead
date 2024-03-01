package com.medHeadReservation.api.mapper;

import com.medHeadReservation.api.dto.ReservationDTO;
import com.medHeadReservation.api.model.Reservation;

public class ReservationMapper {
    public static ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setHospitalId(reservation.getHospitalId());
        dto.setPatientName(reservation.getPatientName());
        dto.setPatientPhone(reservation.getPatientPhone());
        dto.setMail(reservation.getMail());
        dto.setAge(reservation.getAge());
        dto.setSexe(reservation.getSexe());
        dto.setHeure(reservation.getHeure());
        dto.setEtat(reservation.getEtat());
        dto.setEtat_demande(reservation.getEtat_demande());
        return dto;
    }

    public static Reservation toEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId()); // Généralement non nécessaire pour une création
        reservation.setHospitalId(dto.getHospitalId());
        reservation.setPatientName(dto.getPatientName());
        reservation.setPatientPhone(dto.getPatientPhone());
        reservation.setMail(dto.getMail());
        reservation.setAge(dto.getAge());
        reservation.setSexe(dto.getSexe());
        reservation.setHeure(dto.getHeure());
        reservation.setEtat(dto.getEtat());
        reservation.setEtat_demande(dto.getEtat_demande());
        return reservation;
    }
}
