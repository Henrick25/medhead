package com.medHeadReservation.api.model;





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
@Table(name = "hospital")
public class Hospital {
	
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  
	    @Column(name = "name", nullable = false, length = 255)
	    private String name;

	    @Column(name = "latitude", nullable = true)
	    private Double latitude;

	    @Column(name = "longitude", nullable = true)
	    private Double longitude;
	    
	    
	    @Column(name = "lit", nullable = true)
	    private Long lit;
	    
	   @Column(name = "numeroderue", nullable = true, length = 10)
	    private String numeroDeRue;
	    
	  @Column(name = "nomdelarue", nullable = true)
	   private String rue;

	  

	    
	    @Column(name = "postal", nullable = true, length = 10)
	    private String postal;

//		@ManyToMany
		//	@JoinTable(
		//		name = "hospitalSpecialization",
		 //     joinColumns = @JoinColumn(name = "hospital_id"),
		 //     inverseJoinColumns = @JoinColumn(name = "specialization_id")
		//    )
		 
		  //  private Set<Specialization> specializations = new HashSet<>();


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

	

	
		
	  
	    
    
    
}

