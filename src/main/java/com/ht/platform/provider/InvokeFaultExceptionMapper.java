package com.ht.platform.provider;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class InvokeFaultExceptionMapper implements ExceptionMapper<InvokeFault> {

	public Response toResponse(InvokeFault invokeFault) {
		return Response
				.status(Status.FORBIDDEN)
				.type(MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
				.entity(invokeFault)
				.build();

	}

}
