package edu.pingpong.onequarkusapp.resource;

import edu.pingpong.onequarkusapp.service.ServiceOlli;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ResourcesOlli {

    @Inject
    public ServiceOlli service;

    public ResourcesOlli() {}

    @GET
    @Path("/wellcome")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    // curl -w "\n" http://localhost:8080/wellcome/
    public Response hello() {
        return Response.ok("Wellcome Ollivanders!").build();
    }
}
