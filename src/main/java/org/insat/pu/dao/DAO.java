package org.insat.pu.dao;

import java.util.List;
import javax.persistence.*;
import org.insat.pu.entity.*;

public class DAO  implements IDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void ajouterUser(User p) {
	em.persist(p);
	}
	@Override
	public Role getRole(Long id) {
	return em.find(Role.class, id);
	}
	public void ajouterRole(Role r){
		em.persist(r);
	}
	@Override
	public void ajouterUser_Role(User_Role Ur){
		em.persist(Ur);
	}
	@Override
	public List<User> getUserN(String username){	
		Query req=em.createQuery("select u from User u where u.userName=:x");
		req.setParameter("x", username);
		return req.getResultList();
	}
	@Override
	public List<User_Role> getUser_Role(Long id){	
		Query req=em.createQuery("select u from User_Role u where u.user_id=:x");
		req.setParameter("x", id);
		return req.getResultList();
	}
	
	@Override
	public void modifierUser(User c) {
		em.merge(c);
	}
	@Override
	public User getUser(Long idUser) {
		return em.find(User.class, idUser);
	}
	@Override
	public void supprimerUser(Long idUser) {
		User p =em.find(User.class, idUser);
		User_Role u = this.getUser_Role(idUser).get(0);
		em.remove(u);
		em.remove(p);
		
	}
	@Override
	public List<User> listBabySitters() {
		Query req=em.createQuery("select u from User u,User_Role ur where u.idUser=ur.user_id and ur.role_id=1");
		return req.getResultList();
	}
	@Override
	public List<User> BabySittersParSexe(String sexe) {
		Query req=em.createQuery("select u from User u,User_Role ur where u.idUser=ur.user_id and ur.role_id=1 and u.sexe=:x");
		req.setParameter("x", sexe);
		return req.getResultList();
	}
	@Override
	public List<User> BabySittersParAdresse(String adresse) {
		Query req=em.createQuery("select p from User p,User_Role ur where p.idUser=ur.user_id and ur.role_id=1 and p.adresse like :x");
		req.setParameter("x", "%"+adresse+"%");
		return req.getResultList();
	}
	@Override
	public List<User> BabySittersParAge(int ageMin, int ageMax) {
		Query req=em.createQuery("select u from User u,User_Role ur where u.idUser=ur.user_id and ur.role_id=1 and u.age<:y and u.age>:x");
		req.setParameter("x", ageMin);
		req.setParameter("y", ageMax);
		return req.getResultList();
	}
	@Override
	public List<User> BabySittersParMotCle(String mc) {
		Query req=em.createQuery("select p from User p,User_Role ur where p.idUser=ur.user_id and ur.role_id=1 and (p.nom like :x or p.prenom like:x)");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}
	@Override
	public List<User> listParents() {
		Query req=em.createQuery("select u from User u,User_Role ur where u.idUser=ur.user_id and ur.role_id=2");
		return req.getResultList();
	}
	 

	}
