package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.GeneralTreatment;
import at.htl.krankenhaus.model.Patient;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("patient")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class PatientEndpoint {
    @GET
    public Response getAll() {
        return EndpointHelpers.getMany(Patient.listAll());
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id) {
        return EndpointHelpers.get(Patient.findById(id));
    }

    @POST
    public Response post(Patient entity) {
        return EndpointHelpers.post(entity);
    }

    @PUT
    public Response put(Patient entity) {
        return EndpointHelpers.put(entity);
    }

    @DELETE
    @Path("{id}")
    public Response put(@PathParam("id") long id) {
        return EndpointHelpers.delete(Patient.findById(id));
    }
}
