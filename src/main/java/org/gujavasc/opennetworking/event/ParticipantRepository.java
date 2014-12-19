package org.gujavasc.opennetworking.event;

import java.util.List;


public interface ParticipantRepository {
	
	Participant findById(Long id);
	
	Participant findByIdWithEvents(Long id);

	void update(Participant participant);

	List<Participant> findParticipantsBySkill(Long eventId, String skill);

}
