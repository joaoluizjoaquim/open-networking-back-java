package org.gujavasc.opennetworking.project;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class ProjectService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Project> getAll(){
		return entityManager.createQuery(" SELECT p FROM Project p ").getResultList();
	}
	public void create(Project project){
		entityManager.persist(project);
	} 
	
	public void delete(Long id){
		entityManager.remove(entityManager.find(Project.class, id));
	}
	
	
}
