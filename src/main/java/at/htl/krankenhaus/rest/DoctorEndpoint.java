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
public class DoctorEndpoint extends AbstractEndpoint<Doctor> {
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
