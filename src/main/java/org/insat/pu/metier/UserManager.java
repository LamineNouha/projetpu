package org.insat.pu.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.insat.pu.dao.*;
import org.insat.pu.entity.*;

@Transactional
public class UserManager {
	
	private IDAO dao;
	public void setDao(IDAO dao) {
	this.dao = dao;
	}
	
	public void ajouterUser(User p){
		dao.ajouterUser(p);
		
	}
	public Role getRole(Long id) {
		return dao.getRole(id);
		}
	public void ajouterRole(Role r){
		dao.ajouterRole(r);
	}
	public void ajouterUser_Role(User_Role Ur){
		dao.ajouterUser_Role(Ur);
	}
	public List<User> getUserN(String username){
		return dao.getUserN(username);
	}
	public void modifierUser(User c) {
		dao.modifierUser(c);
		}

	public void supprimerUser(Long idUser) {
	dao.supprimerUser(idUser);
		
	}

	public List<User> listBabySitters() {
		
		return dao.listBabySitters();
	}

	public List<User> BabySittersParSexe(String sexe) {
		
		return dao.BabySittersParSexe(sexe);
	}

	public List<User> BabySittersParAdresse(String adresse) {
		
		return dao.BabySittersParAdresse(adresse);
	}

	public List<User> BabySittersParAge(int ageMin, int ageMax) {

		return dao.BabySittersParAge(ageMin,ageMax);
	}

	public List<User> BabySittersParMotCle(String mc) {
		
		return dao.BabySittersParMotCle(mc);
	}

	public User getUser(Long id) {
	return dao.getUser(id);
	}

	public List<User> listParents() {
		
		return dao.listParents();
	}

	

}
