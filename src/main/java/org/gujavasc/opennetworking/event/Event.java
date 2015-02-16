package org.gujavasc.opennetworking.event;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name=Event.FIND_NAME, query="SELECT e FROM Event e WHERE upper(e.name) like :eventName "),
	@NamedQuery(name=Event.FIND_ID, query="SELECT e FROM Event e WHERE e.id = :eventId "),
	@NamedQuery(name=Event.FIND_PARTICIPANTS, query="SELECT e FROM Event e LEFT JOIN FETCH e.participants WHERE e.id = :eventId ")
})
public class Event {

	public static final String FIND_NAME = "Event.findByName";
	public static final String FIND_ID = "Event.findById";
	public static final String FIND_PARTICIPANTS = "Event.findParticipants";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	private Set<Participant> participants = new HashSet<Participant>();
	
	private long totalParticipants = 0L;
		
	public Event() {
	}
	
	public Event(Long id, String name){
		this.id = id;
		this.name = name;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Long getTotalParticipants(){
		return participants == null ? totalParticipants : participants.size();
	}

	public void checkin(Participant participant) {
		if(!participants.add(participant))
			throw new RuntimeException("Participant already checked in event.");
		totalParticipants++;
	}
	
	public void checkout(Participant participant){
		if(!participants.remove(participant))
			throw new RuntimeException("Participant not checked in event.");
		totalParticipants--;
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
		Event other = (Event) obj;
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
	
	
	
}
