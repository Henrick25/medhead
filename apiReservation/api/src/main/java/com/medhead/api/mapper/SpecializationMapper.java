package com.medhead.api.mapper;

import com.medhead.api.dto.SpecializationDTO;
import com.medhead.api.model.Specialization;

public class SpecializationMapper {
	public static SpecializationDTO toDto(Specialization entity) {
        if (entity == null) {
            return null;
        }

        SpecializationDTO dto = new SpecializationDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGroupeSpecialite(GroupeSpecialiteMapper.toDto(entity.getGroupeSpecialite()));
        return dto;
    }

    public static Specialization toEntity(SpecializationDTO dto) {
        if (dto == null) {
            return null;
        }

        Specialization entity = new Specialization();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setGroupeSpecialite(GroupeSpecialiteMapper.toEntity(dto.getGroupeSpecialite()));
        return entity;
    }
}
