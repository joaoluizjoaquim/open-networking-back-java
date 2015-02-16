package org.gujavasc.opennetworking.event;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Local(ParticipantService.class)
@Stateless
public class ParticipantEJBImpl implements ParticipantService {

	@Inject
	private ParticipantRepository repository;
	
	@Override
	public Participant findById(@NotNull Long participantId) {
		return repository.findById(participantId);
	}
	
}
