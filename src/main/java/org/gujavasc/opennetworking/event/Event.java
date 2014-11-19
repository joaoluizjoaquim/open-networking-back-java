package org.gujavasc.opennetworking.event;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToMany
	private Set<Participant> participants = new HashSet<Participant>();
	
	@Transient
	private Long totalParticipants;
		
	public Event() {
	}
	
	public Event(Long id, String name, Long totalParticipants){
		this.id = id;
		this.name = name;
		this.totalParticipants = totalParticipants;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	@Transient
	public Long getTotalParticipants(){
		return totalParticipants;
	}
	
}
