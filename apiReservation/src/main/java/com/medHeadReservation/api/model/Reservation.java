package com.medHeadReservation.api.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hospital_id")
    private Long hospitalId;

    @Column(name = "patient_name", nullable = false, length = 255)
    private String patientName;

    @Column(name = "patient_phone", nullable = false, length = 20)
    private String patientPhone;

    @Column(nullable = false, length = 255)
    private String mail;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 10)
    private String sexe;

    @Column(nullable = false, length = 5)
    private String heure;

    @Column(nullable = false, length = 255)
    private String etat;

    @Column(nullable = false, length = 255)
    private Boolean etat_demande;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Boolean getEtat_demande() {
		return etat_demande;
	}

	public void setEtat_demande(Boolean etat_demande) {
		this.etat_demande = etat_demande;
	}
    
    
    
}