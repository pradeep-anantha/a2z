package com.a2z.core.cache;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/cache")
@Api(value="Cache Management", description="/Cache Management Services")
public interface ICacheService {
	
	@GET
    @Path("/clearCache")
    @Produces({"application/json"})
	@ApiOperation(value="clear All Caches", response=String.class, position=1)
	public CacheServiceResponse clearCache();
	
	@POST
    @Path("/clearSpecificCache")
    @Produces({"application/json"})
	@ApiOperation(value="clear specific Cache", response=String.class, position=2)
	public CacheServiceResponse clearSpecificCache(
			@ApiParam(value="cache name", required = true) String cacheName);
	
	@GET
    @Path("/reloadCache")
    @Produces({"application/json"})
	@ApiOperation(value="refresh All Caches", response=String.class, position=3)
	public CacheServiceResponse reloadCache();
	
	@POST
    @Path("/reloadSpecificCache")
    @Produces({"application/json"})
	@ApiOperation(value="reload specific Cache", response=String.class, position=4)
	public CacheServiceResponse reloadSpecificCache(
			@ApiParam(value="cache name", required = true) String cacheName);
	
	@POST
    @Path("/addEntryToCache")
    @Produces({"application/json"})
	@ApiOperation(value="add entry to the cache", response=String.class, position=5)
	public CacheServiceResponse addEntryToCache(
			@ApiParam(value="cache name", required = true)String cacheName, 
			@ApiParam(value="entry key", required = true)String key, 
			@ApiParam(value="entry value", required = true)Object value);
	
	@POST
    @Path("/removeEntryFromCache")
    @Produces({"application/json"})
	@ApiOperation(value="remove entry from the cache", response=String.class, position=6)
	public CacheServiceResponse removeEntryFromCache(
			@ApiParam(value="cache name", required = true)String cacheName, 
			@ApiParam(value="entry key", required = true)String key, 
			@ApiParam(value="entry value", required = true)Object value);

}
