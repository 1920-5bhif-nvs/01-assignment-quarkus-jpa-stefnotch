package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.Doctor;
import at.htl.krankenhaus.model.DrugTreatment;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("drugtreatment")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class DrugTreatmentEndpoint {
    @GET
    public Response getAll() {
        return EndpointHelpers.getMany(DrugTreatment.listAll());
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id) {
        return EndpointHelpers.get(DrugTreatment.findById(id));
    }

    @POST
    public Response post(DrugTreatment entity) {
        return EndpointHelpers.post(entity);
    }

    @PUT
    public Response put(DrugTreatment entity) {
        return EndpointHelpers.put(entity);
    }

    @DELETE
    @Path("{id}")
    public Response put(@PathParam("id") long id) {
        return EndpointHelpers.delete(DrugTreatment.findById(id));
    }
}
