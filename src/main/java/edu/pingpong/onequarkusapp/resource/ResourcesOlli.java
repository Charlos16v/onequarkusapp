package edu.pingpong.onequarkusapp.resource;

import edu.pingpong.onequarkusapp.entity.Item;
import edu.pingpong.onequarkusapp.entity.Orden;
import edu.pingpong.onequarkusapp.entity.Usuaria;
import edu.pingpong.onequarkusapp.service.ServiceOlli;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
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

    @POST
    @Path("/ordena")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ordenar(/*@Valid*/ Orden orden) {
        Orden newOrden = service.comanda(orden.getUser().getNombre(), orden.getItem().getNombre());
        return newOrden != null ? Response.status(Response.Status.CREATED)
                .entity(newOrden).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/pedidos/{usuaria}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedidosUsuaria(@PathParam("usuaria") String usuariaNombre) {
        List<Orden> ordenesUsuaria = service.cargaOrden(usuariaNombre);
        return !ordenesUsuaria.isEmpty() ?  Response.ok(ordenesUsuaria).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }
}
