package com.medhead.api.mapper;

import com.medhead.api.dto.GroupeSpecialiteDTO;
import com.medhead.api.model.GroupeSpecialite;

public class GroupeSpecialiteMapper {
	public static GroupeSpecialiteDTO toDto(GroupeSpecialite entity) {
        if (entity == null) {
            return null;
        }

        GroupeSpecialiteDTO dto = new GroupeSpecialiteDTO();
        dto.setIdGroupe(entity.getIdGroupe());
        dto.setNomGroupe(entity.getNomGroupe());
        return dto;
    }

    public static GroupeSpecialite toEntity(GroupeSpecialiteDTO dto) {
        if (dto == null) {
            return null;
        }

        GroupeSpecialite entity = new GroupeSpecialite();
        entity.setIdGroupe(dto.getIdGroupe());
        entity.setNomGroupe(dto.getNomGroupe());
        return entity;
    }
}
