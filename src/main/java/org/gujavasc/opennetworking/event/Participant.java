package org.gujavasc.opennetworking.event;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Participant.FIND_ID, 
			query="SELECT p FROM Participant p WHERE p.id = :participantId "),
	@NamedQuery(name=Participant.FIND_EVENTS, 
			query="SELECT p FROM Participant p LEFT JOIN FETCH p.events WHERE p.id = :participantId "),
	@NamedQuery(name=Participant.FIND_SKILLS, 
			query="SELECT p FROM Participant p JOIN p.events e JOIN p.skills s WHERE upper(s.name) like :skill and e.id = :eventId ")
})
public class Participant {

	public static final String FIND_ID = "Participant.findById";
	public static final String FIND_EVENTS = "Event.findEvents";
	public static final String FIND_SKILLS = "Event.findBySkills";
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	
	@ManyToMany()
	private Set<Skill> skills = new HashSet<>();
	
	@ManyToMany
	private Set<Event> events = new HashSet<>();
	
	public void addEvent(Event event){
		if(!events.add(event)){
			throw new RuntimeException();
		}
	}
	
	public void removeEvent(Event event){
		if(!events.remove(event)){
			throw new RuntimeException();
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
}
