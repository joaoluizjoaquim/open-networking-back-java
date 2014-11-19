package org.gujavasc.opennetworking.utils;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;
import javax.ws.rs.core.UriInfo;

public class LinkBuilder {
	
	private StringBuilder pathUrl = new StringBuilder();
	private StringBuilder queryParams = new StringBuilder();
	
	public LinkBuilder() {
//		pathUrl.append(uriInfo.getBaseUri().toASCIIString());
	}
	
	public LinkBuilder(UriInfo uriInfo) {
		pathUrl.append(uriInfo.getBaseUri().toASCIIString());
	}
	
	public String build() {
		return pathUrl.toString() + queryParams.toString();
	}
	
	public LinkBuilder addPath(@NotNull Class clazz) {
		Path pathAnnotation = (Path)clazz.getAnnotation(Path.class);
		if(pathAnnotation == null){ 
			throw new IllegalArgumentException("Class "+clazz.getCanonicalName()+" don't have javax.ws.rs.Path annotation.");
		}
		pathUrl.append(pathAnnotation.value());
		return this;
	}

	public LinkBuilder addPath(@NotNull Long id) {
		pathUrl.append("/"+id);
		return this;
	}

	public LinkBuilder addQueryParam(@NotNull String name,@NotNull String value){
		Boolean isEmpty = queryParams.length() == 0;
		String separator = isEmpty ? "?" : "&";
		queryParams.append(separator+name+"="+value);
		return this;
	}
	
}
