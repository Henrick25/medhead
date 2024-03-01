package com.medHeadReservation.api.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HopitalDTO {



        private Long id;
        private String name;
        private Double latitude;
        private Double longitude;
        private Long lit;
        private String numeroDeRue;
        private String rue;
        private String postal;
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
