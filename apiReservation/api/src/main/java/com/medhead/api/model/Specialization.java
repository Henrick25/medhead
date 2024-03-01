package com.medhead.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name= "specialization")
public class Specialization {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name", nullable = false, length = 255)
	    private String name;

	    @Column(name = "idGroupe", nullable = true)
	    private Integer idGroupe;

	    @ManyToOne
	    @JoinColumn(name = "idGroupe", referencedColumnName = "id_groupe", insertable = false, updatable = false)
	    private GroupeSpecialite groupeSpecialite;

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

		public GroupeSpecialite getGroupeSpecialite() {
			return groupeSpecialite;
		}

		public void setGroupeSpecialite(GroupeSpecialite groupeSpecialite) {
			this.groupeSpecialite = groupeSpecialite;
		}
	    
	    
}
