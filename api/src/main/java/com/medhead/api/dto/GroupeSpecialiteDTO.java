package com.medhead.api.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupeSpecialiteDTO {

    private Integer idGroupe;
    private String nomGroupe;

    // Constructors, si nécessaire
    // Pour une meilleure pratique, incluez un constructeur sans argument et un constructeur avec tous les arguments

    public GroupeSpecialiteDTO() {}

    public GroupeSpecialiteDTO(Integer idGroupe, String nomGroupe) {
        this.idGroupe = idGroupe;
        this.nomGroupe = nomGroupe;
    }

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

    // toString, hashCode, et equals methods, si nécessaire
    
    
}
