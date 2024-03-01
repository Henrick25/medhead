package com.medhead.api.mapper;

import com.medhead.api.dto.HospitalDTO;
import com.medhead.api.model.Hospital;

public class HospitalMapper {
	 public static HospitalDTO toDto(Hospital entity) {
	        if (entity == null) {
	            return null;
	        }

	        HospitalDTO dto = new HospitalDTO();
	        dto.setId(entity.getId());
	        dto.setName(entity.getName());
	        dto.setLatitude(entity.getLatitude());
	        dto.setLongitude(entity.getLongitude());
	        dto.setLit(entity.getLit());
	        dto.setNumeroDeRue(entity.getNumeroDeRue());
	        dto.setRue(entity.getRue());
	        dto.setPostal(entity.getPostal());
	        // Mappez les spécialisations si nécessaire, par exemple:
	        // dto.setSpecializations(entity.getSpecializations().stream().map(SpecializationMapper::toDto).collect(Collectors.toSet()));
	        return dto;
	    }

	    public static Hospital toEntity(HospitalDTO dto) {
	        if (dto == null) {
	            return null;
	        }

	        Hospital entity = new Hospital();
	        entity.setId(dto.getId());
	        entity.setName(dto.getName());
	        entity.setLatitude(dto.getLatitude());
	        entity.setLongitude(dto.getLongitude());
	        entity.setLit(dto.getLit());
	        entity.setNumeroDeRue(dto.getNumeroDeRue());
	        entity.setRue(dto.getRue());
	        entity.setPostal(dto.getPostal());
	        // Mappez les spécialisations si nécessaire
	        return entity;
	    }
}
