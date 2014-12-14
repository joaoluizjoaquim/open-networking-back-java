package org.gujavasc.opennetworking.event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

}
