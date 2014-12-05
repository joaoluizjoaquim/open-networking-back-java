package org.gujavasc.opennetworking.event;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;

@Local(value=ParticipantService.class)
@Stateless
public class ParticipantEJBImpl implements ParticipantService {

	@Override
	public Participant findById(@NotNull Long l) {
		return null;
		
	}

}
