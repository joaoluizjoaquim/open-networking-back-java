package org.gujavasc.opennetworking.event;

import javax.validation.constraints.NotNull;

public interface ParticipantService {

	Participant findById(@NotNull Long l);

}
