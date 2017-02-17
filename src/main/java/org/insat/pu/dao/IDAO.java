package org.insat.pu.dao;
import java.util.List;

import org.insat.pu.entity.Role;
import org.insat.pu.entity.User;
import org.insat.pu.entity.User_Role;



public interface IDAO {
	
	public void ajouterUser(User p) ;
	public Role getRole(Long id);
	public List<User> getUserN(String username);
	public void ajouterRole(Role r);
	public void ajouterUser_Role(User_Role Ur);
	public void modifierUser(User c);
	public User getUser(Long id);
	public void supprimerUser(Long idUser);
	List<User_Role> getUser_Role(Long id);
	public List<User> listBabySitters();
	public List<User> BabySittersParSexe(String sexe);
	public List<User> BabySittersParAdresse(String adresse);
	public List<User> BabySittersParAge(int ageMin, int ageMax);
	public List<User> BabySittersParMotCle(String mc);
	public List<User> listParents();
}
