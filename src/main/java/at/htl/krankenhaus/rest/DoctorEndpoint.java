package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.Doctor;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("doctor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class DoctorEndpoint {
    @GET
    public Response getAll() {
        return EndpointHelpers.getMany(Doctor.listAll());
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id) {
        return EndpointHelpers.get(Doctor.findById(id));
    }

    @POST
    public Response post(Doctor entity) {
        return EndpointHelpers.post(entity);
    }

    @PUT
    public Response put(Doctor entity) {
        return EndpointHelpers.put(entity);
    }

    @DELETE
    @Path("{id}")
    public Response put(@PathParam("id") long id) {
        return EndpointHelpers.delete(Doctor.findById(id));
    }

    @GET
    @Path("/name/{name}")
    @Counted(name = "doctor_get_count", description = "How many times has a doctor been looked up using the name")
    @Timed(name = "doctor_get_duration_milliseconds", unit = MetricUnits.MILLISECONDS)
    public Response getDoctor(@PathParam("name") String name) {
        Doctor doctor;
        try {
             doctor = Doctor.findByName(name);
        } catch (NoResultException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(doctor).build();
    }

    @Gauge(name = "meaningful_number", unit = MetricUnits.NONE)
    public int RandomNumber() {
        return 4; // Chosen by a fair dice roll. Guaranteed to be random.
    }
}
