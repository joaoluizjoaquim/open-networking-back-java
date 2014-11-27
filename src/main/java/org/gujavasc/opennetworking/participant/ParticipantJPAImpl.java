package org.gujavasc.opennetworking.participant;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

class ParticipantJPAImpl implements ParticipantRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@Override
	public Participant findById(Long id){
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT p FROM Participant p WHERE p.id = :participantId ");
		TypedQuery<Participant> query = entityManager.createQuery(jpql.toString(),Participant.class);
		query.setParameter("participantId", id);
		return query.getSingleResult();
	}

}
