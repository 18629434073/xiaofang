package com.ht.webservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces({ MediaType.APPLICATION_JSON })
public interface IHelloRestful {
	
	@GET
	@Path("/say/{username}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }) 
	public String say(@PathParam("username") String username);
}
