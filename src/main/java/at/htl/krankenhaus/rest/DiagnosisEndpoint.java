package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.Diagnosis;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("diagnosis")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class DiagnosisEndpoint {
    @GET
    public Response getAll() {
        return EndpointHelpers.getMany(Diagnosis.listAll());
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id) {
        return EndpointHelpers.get(Diagnosis.findById(id));
    }

    @POST
    public Response post(Diagnosis entity) {
        return EndpointHelpers.post(entity);
    }

    @PUT
    public Response put(Diagnosis entity) {
        return EndpointHelpers.put(entity);
    }

    @DELETE
    @Path("{id}")
    public Response put(@PathParam("id") long id) {
        return EndpointHelpers.delete(Diagnosis.findById(id));
    }
}