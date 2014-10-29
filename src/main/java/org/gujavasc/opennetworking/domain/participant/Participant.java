package org.gujavasc.opennetworking.domain.participant;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.gujavasc.opennetworking.domain.event.Event;


@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;

	@ManyToMany(mappedBy="participants",cascade={CascadeType.ALL})
	private Set<Event> events = new HashSet<>();
	
	public Long getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Set<Event> getEvents() {
		return this.events;
	}
	
}
