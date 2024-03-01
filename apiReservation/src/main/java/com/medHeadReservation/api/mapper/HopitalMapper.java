package com.medHeadReservation.api.mapper;

import com.medHeadReservation.api.dto.HopitalDTO;
import com.medHeadReservation.api.model.Hospital;

public class HopitalMapper {

    // Convertit une entité Hospital en un HospitalDTO
    public static HopitalDTO toDTO(Hospital hospital) {
        if (hospital == null) {
            return null;
        }

        HopitalDTO dto = new HopitalDTO();
        dto.setId(hospital.getId());
        dto.setName(hospital.getName());
        dto.setLatitude(hospital.getLatitude());
        dto.setLongitude(hospital.getLongitude());
        dto.setLit(hospital.getLit());
        dto.setNumeroDeRue(hospital.getNumeroDeRue());
        dto.setRue(hospital.getRue());
        dto.setPostal(hospital.getPostal());

        return dto;
    }

    // Convertit un HospitalDTO en une entité Hospital
    public static Hospital toEntity(HopitalDTO dto) {
        if (dto == null) {
            return null;
        }

        Hospital hospital = new Hospital();
        hospital.setId(dto.getId()); // Assurez-vous que l'ID est null ou géré correctement lors de la création de nouvelles entités
        hospital.setName(dto.getName());
        hospital.setLatitude(dto.getLatitude());
        hospital.setLongitude(dto.getLongitude());
        hospital.setLit(dto.getLit());
        hospital.setNumeroDeRue(dto.getNumeroDeRue());
        hospital.setRue(dto.getRue());
        hospital.setPostal(dto.getPostal());

        return hospital;
    }
    
    // Ajoutez d'autres méthodes si nécessaire, par exemple pour les listes ou les collections
}
