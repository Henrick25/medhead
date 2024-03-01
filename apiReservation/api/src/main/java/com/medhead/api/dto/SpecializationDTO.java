package com.medhead.api.dto;

import com.medhead.api.model.Specialization;

import lombok.Getter;
import lombok.Setter;

/**
 * Specialization Data Transfer Object (DTO) class.
 */
@Getter
@Setter
public class SpecializationDTO {

    private Long id;
    private String name;
    private Integer idGroupe;
    private GroupeSpecialiteDTO groupeSpecialite;

 

  

    public SpecializationDTO() {}

    public SpecializationDTO(Long id, String name, GroupeSpecialiteDTO groupeSpecialite) {
        this.id = id;
        this.name = name;
        this.groupeSpecialite = groupeSpecialite;
    }
    public static SpecializationDTO convertToDTO(Specialization specialization) {
    	   SpecializationDTO dto = new SpecializationDTO();
    	    dto.setId(specialization.getId());
    	    dto.setName(specialization.getName());
    	    // Supposons que SpecializationDTO n'inclut pas idGroupe directement 
    	    // ou que vous ne souhaitez pas l'exposer dans le DTO.
    	    // Si GroupeSpecialite est inclus dans SpecializationDTO, convertissez-le aussi.
    	    if (specialization.getGroupeSpecialite() != null) {
    	        GroupeSpecialiteDTO groupeSpecialiteDTO = new GroupeSpecialiteDTO();
    	        groupeSpecialiteDTO.setIdGroupe(specialization.getGroupeSpecialite().getIdGroupe());
    	        groupeSpecialiteDTO.setNomGroupe(specialization.getGroupeSpecialite().getNomGroupe());
    	        dto.setGroupeSpecialite(groupeSpecialiteDTO);
    	    }

    	    return dto;
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	public GroupeSpecialiteDTO getGroupeSpecialite() {
		return groupeSpecialite;
	}

	public void setGroupeSpecialite(GroupeSpecialiteDTO groupeSpecialite) {
		this.groupeSpecialite = groupeSpecialite;
	}
    
    
}
