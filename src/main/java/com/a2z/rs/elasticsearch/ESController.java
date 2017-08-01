package com.a2z.rs.elasticsearch;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.elasticsearch.client.Client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Path("/es")
@Api(value="ElasticSearch", description="Elasticsearch Admin Services")
public class ESController {
	
	private ElasticServiceManager esManager;
	private Client client;
			
	public ElasticServiceManager getEsManager() {
		return esManager;
	}

	public void setEsManager(ElasticServiceManager esManager) {
		this.esManager = esManager;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@GET
    @Path("/resetClient")
    @Produces({"application/json"})
	@ApiOperation(value="Reset the ES Client", response=String.class, position=1)
	public Response resetClient() {
		String message = "Client reset successful";
		int statusCode = 200;
		ESServiceResponse response = null;
		try {
			esManager.init();
			this.client = esManager.getClient();
			
		} catch (Exception e) {
			e.printStackTrace();
			statusCode =500;
		}
		response = new ESServiceResponse(statusCode, message);
		return Response.status(statusCode).entity(response).build();
	}

	@POST
	@Path(value = "/createIndex")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	@ApiOperation(value="create Index", response=String.class)
	public Response createIndex(ESServiceRequest request) {
		String message = "Successfully created index - " + request.getIndexName();
		int statusCode = 200;

		ESServiceResponse response = new ESServiceResponse(statusCode, message);

		return Response.status(statusCode).entity(response).build();
	}

	@POST
	@Path(value = "/deleteIndex")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	@ApiOperation(value="delete Index", response=String.class)
	public Response deleteIndex(ESServiceRequest request) {
		String message = "Successfully deleted index - " + request.getIndexName();
		int statusCode = 200;

		ESServiceResponse response = new ESServiceResponse(statusCode, message);

		return Response.status(statusCode).entity(response).build();
	}

	@POST
	@Path(value = "/createAlias")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	@ApiOperation(value="create Alias", response=String.class)
	public Response createAlias(ESServiceRequest request) {
		String message = "Successfully created alias - " + request.getAliasName() + " for the index - "+ request.getIndexName();
		int statusCode = 200;

		ESServiceResponse response = new ESServiceResponse(statusCode, message);

		return Response.status(statusCode).entity(response).build();
	}

	@POST
	@Path(value = "/deleteAlias")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	@ApiOperation(value="delete Alias", response=String.class)
	public Response deleteAlias(ESServiceRequest request) {
		String message = "Successfully deleted alias - " + request.getAliasName() + " for the index - "+ request.getIndexName();
		int statusCode = 200;

		ESServiceResponse response = new ESServiceResponse(statusCode, message);

		return Response.status(statusCode).entity(response).build();
	}

}
