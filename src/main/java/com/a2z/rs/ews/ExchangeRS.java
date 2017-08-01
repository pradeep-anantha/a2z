package com.a2z.rs.ews;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/ews")
@Api(value="Exchange Webservices", description="Exchange Webservices")
public interface ExchangeRS {
	
	@GET
    @Path("/sendTestEmail")
    @Produces({"application/json"})
	@ApiOperation(value="Sends the test email", response=String.class, position=1)
	public Response sendTestEmail();
	

}
