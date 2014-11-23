package org.gujavasc.opennetworking.event;

import java.util.List;

import javax.validation.constraints.NotNull;

public interface EventService {

	List<Event> findByName(String name);
	
	Event findById(@NotNull Long id);
}
