package org.gujavasc.opennetworking.event;

public interface ParticipantRepository {
	
	Participant findById(Long id);
	
	Participant findByIdWithEvents(Long id);

	void update(Participant participant);

}
