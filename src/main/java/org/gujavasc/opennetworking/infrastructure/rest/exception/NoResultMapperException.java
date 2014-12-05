package org.gujavasc.opennetworking.infrastructure.rest.exception;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sun.messaging.jmq.io.Status;

@Provider
public class NoResultMapperException implements ExceptionMapper<NoResultException> {

	@Override
	public Response toResponse(NoResultException exception) {
		return Response.status(Status.NOT_FOUND).build();
	}

}
