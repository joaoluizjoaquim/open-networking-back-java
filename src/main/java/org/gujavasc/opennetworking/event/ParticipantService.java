package org.gujavasc.opennetworking.event;

import javax.validation.constraints.NotNull;

public interface ParticipantService {

	Participant findById(@NotNull Long l);

	void checkin(@NotNull Long eventId, @NotNull Long participantId);

	void checkout(@NotNull Long eventId, @NotNull Long participantId);

}
