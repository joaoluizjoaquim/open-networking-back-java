package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

class ParticipantJPAImpl implements ParticipantRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@Override
	public Participant findById(Long id){
		TypedQuery<Participant> query = entityManager.createNamedQuery(Participant.FIND_ID, Participant.class);
		query.setParameter("participantId", id);
		return query.getSingleResult();
	}
	
	@Override
	public Participant findByIdWithEvents(Long id){
		TypedQuery<Participant> query = entityManager.createNamedQuery(Participant.FIND_ID, Participant.class);
		query.setParameter("participantId", id);
		return query.getSingleResult();
	}

	@Override
	public void update(Participant participant) {
		entityManager.merge(participant);
	}

	@Override
	public List<Participant> findParticipantsBySkill(Long eventId, String skill) {
		TypedQuery<Participant> query = entityManager.createNamedQuery(Participant.FIND_SKILLS_EVENT, Participant.class);
		
		query.setParameter("eventId", eventId);
		query.setParameter("skill", "%"+skill.toUpperCase()+"%");
		return query.getResultList();
	}

}
