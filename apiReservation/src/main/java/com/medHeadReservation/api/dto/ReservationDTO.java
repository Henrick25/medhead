package com.medHeadReservation.api.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    private Long id;
    private Long hospitalId;
    private String patientName;
    private String patientPhone;
    private String mail;
    private Integer age;
    private String sexe;
    private String heure;
    private String etat;
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
