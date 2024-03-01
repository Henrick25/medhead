package com.medhead.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "groupes_specialites")
public class GroupeSpecialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_groupe", nullable = false)
    private Integer idGroupe;

    @Column(name = "nom_groupe", nullable = false, length = 255)
    private String nomGroupe;

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

    // Constructors, getters and setters
    
}
