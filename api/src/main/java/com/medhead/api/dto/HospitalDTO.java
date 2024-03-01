package com.medhead.api.dto;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.medhead.api.model.Hospital;
import com.medhead.api.model.Specialization;

import lombok.Getter;
import lombok.Setter;

/**
 * Hospital Data Transfer Object (DTO) class.
 */

@Getter
@Setter
public class HospitalDTO {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Long lit;
    private String numeroDeRue;
    private String rue;
    private String postal;
    private Set<SpecializationDTO> specializations;
    
    
    public static HospitalDTO convertToDTO(Hospital hospital) {
        HospitalDTO dto = new HospitalDTO();
        dto.setId(hospital.getId());
        dto.setName(hospital.getName());
        dto.setLatitude(hospital.getLatitude());
        dto.setLongitude(hospital.getLongitude());
        dto.setLit(hospital.getLit());
        dto.setNumeroDeRue(hospital.getNumeroDeRue());
        dto.setRue(hospital.getRue());
        dto.setPostal(hospital.getPostal());
       // if (hospital.getSpecializations() != null) {
        //    Set<SpecializationDTO> specializationDTOs = hospital.getSpecializations().stream()
        //            .map(specialization -> SpecializationDTO.convertToDTO(specialization))
        //            .collect(Collectors.toSet());
       //     dto.setSpecializations(specializationDTOs);
       // }
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
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Long getLit() {
		return lit;
	}
	public void setLit(Long lit) {
		this.lit = lit;
	}
	public String getNumeroDeRue() {
		return numeroDeRue;
	}
	public void setNumeroDeRue(String numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public Set<SpecializationDTO> getSpecializations() {
		return specializations;
	}
	public void setSpecializations(Set<SpecializationDTO> specializations) {
		this.specializations = specializations;
	}

   
}

