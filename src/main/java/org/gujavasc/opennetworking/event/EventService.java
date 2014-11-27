package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.validation.constraints.NotNull;

public interface EventService {

	List<Event> findByName(String name);
	
	Event findById(@NotNull Long id);
	
	void checkin(@NotNull Long eventId,@NotNull Long participantId);
	
	void checkout(@NotNull Long eventId,@NotNull Long participantId);
}
