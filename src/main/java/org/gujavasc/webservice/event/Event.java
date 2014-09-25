package org.gujavasc.webservice.event;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	public Event() {}
	
	public Event(Integer id,String name) {
		this();
		this.id = Long.valueOf(id);
		this.name = name;
	}
	
	public Integer getTotalPaticipants(){
		return participants.size();
	}
	
	public Long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
}
