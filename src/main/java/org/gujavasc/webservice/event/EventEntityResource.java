package org.gujavasc.webservice.event;

public class EventEntityResource extends AbstractEntityResource {

	private Long id;
	private String name;

	public EventEntityResource() {
	}
	
	public EventEntityResource(Long id, String name){
		new LinkBuilder();
		this.id = id;
		this.name = name;
	}
	
	public void detail(){
	}
	
	
}
