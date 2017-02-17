package org.insat.pu.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long role_id;
	private String roleName;
	
	
	public Role() {
		super();
	}
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	public Long getIdRole() {
		return role_id;
	}
	public void setIdRole(Long idRole) {
		this.role_id = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	

}

