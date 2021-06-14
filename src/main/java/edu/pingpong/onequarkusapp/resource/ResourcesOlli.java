package edu.pingpong.onequarkusapp.resource;

import edu.pingpong.onequarkusapp.entity.Usuaria;
import edu.pingpong.onequarkusapp.service.ServiceOlli;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

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

    @GET
    @Path("/usuaria/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuaria(@PathParam("nombre") String usuariaNombre) {
        Usuaria usuaria = service.cargaUsuaria(usuariaNombre);
        return !usuaria.getNombre().equals("") ? Response.ok(usuaria).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
}
