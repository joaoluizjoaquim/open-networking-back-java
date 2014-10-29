package org.gujavasc.opennetworking.domain.event;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.gujavasc.opennetworking.domain.participant.Participant;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@NotNull
	String name;
	
	@ManyToMany
	Set<Participant> participants = new HashSet<Participant>();
	
	public Integer getTotalPaticipants(){
		return participants.size();
	}
	
	public Long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void checkin(Participant participant){
		if(!participants.add(participant)) throw new RuntimeException();
	}

	public void checkout(Participant participant) {
		if(!participants.remove(participant)) throw new RuntimeException();
	}
	
}
