package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.Doctor;
import at.htl.krankenhaus.model.GeneralTreatment;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("generaltreatment")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class GeneralTreatmentEndpoint {
    @GET
    public Response getAll() {
        return EndpointHelpers.getMany(GeneralTreatment.listAll());
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id) {
        return EndpointHelpers.get(GeneralTreatment.findById(id));
    }

    @POST
    public Response post(GeneralTreatment entity) {
        return EndpointHelpers.post(entity);
    }

    @PUT
    public Response put(GeneralTreatment entity) {
        return EndpointHelpers.put(entity);
    }

    @DELETE
    @Path("{id}")
    public Response put(@PathParam("id") long id) {
        return EndpointHelpers.delete(GeneralTreatment.findById(id));
    }

}
