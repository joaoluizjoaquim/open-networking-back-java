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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name=Event.FIND_NAME, query="SELECT new org.gujavasc.opennetworking.event.Event(e.id,e.name,count(p)) FROM Event e LEFT JOIN e.participants p WHERE upper(e.name) like :eventName GROUP BY e.id, p.id"),
	@NamedQuery(name=Event.FIND_ID, query="SELECT new org.gujavasc.opennetworking.event.Event(e.id,e.name,count(p)) FROM Event e LEFT JOIN e.participants p WHERE e.id = :eventId GROUP BY e.id"),
	@NamedQuery(name=Event.FIND_PARTICIPANTS, query="SELECT e FROM Event e LEFT JOIN FETCH e.participants WHERE e.id = :eventId")
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
	
	@ManyToMany(mappedBy="events")
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

	public void checkin(Participant participant) {
		if(!participants.add(participant))
			throw new RuntimeException("Participant already checked in event.");
	}
	
	public void checkout(Participant participant){
		if(!participants.remove(participant))
			throw new RuntimeException("Participant not checked in event.");
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
