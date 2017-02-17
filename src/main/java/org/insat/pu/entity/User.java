package org.insat.pu.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="users")
public class User implements Serializable {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long idUser;
		 @NotEmpty
		 @Size(min=6, max=30)
		private String password;
		 @NotEmpty
		private String userName;
		 @NotEmpty
		private String email;
		private String nom;
		private String prenom;
		private String adresse;
		private String tel;
		private String description;
		private String sexe;
		private double salaire;
		private int age; 
		private String photo;
		private int age_max;
		private int age_min;
		private boolean actived;

		
		
		public User() {
			super();
		}
		public User(String userName,String password, boolean actived) {
			super();
			this.password = password;
			this.userName = userName;
			this.setActived(actived);
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getSalaire() {
			return salaire;
		}
		public void setSalaire(double salaire) {
			this.salaire = salaire;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public Long getIdUser() {
			return idUser;
		}
		public void setIdUser(Long idUser) {
			this.idUser = idUser;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nomUser) {
			this.nom = nomUser;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		
		public String getSexe() {
			return sexe;
		}
		public void setSexe(String sexe) {
			this.sexe = sexe;
		}
		public boolean isActived() {
			return actived;
		}
		public void setActived(boolean actived) {
			this.actived = actived;
		}
		public int getAge_max() {
			return age_max;
		}
		public void setAge_max(int age_max) {
			this.age_max = age_max;
		}
		public int getAge_min() {
			return age_min;
		}
		public void setAge_min(int age_min) {
			this.age_min = age_min;
		}


}
