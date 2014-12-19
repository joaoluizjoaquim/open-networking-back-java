package org.gujavasc.opennetworking.event;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skill {

	@Id
	private Long id;
	
	@ManyToMany(mappedBy="skills")
	private Set<Participant> participants;
	
	private String name;

	public String getName() {
		return name;
	}	
	
}
