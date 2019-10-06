package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.business.DoctorDao;
import at.htl.krankenhaus.model.Doctor;
import at.htl.krankenhaus.model.DrugTreatment;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("doctor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorEndpoint extends AbstractEndpoint<Doctor, DoctorDao> {
    @GET
    @Path("/name/{name}")
    public Response getDoctor(@PathParam("name") String name) {
        Doctor doctor;
        try {
             doctor = this.dao.getEntityManager()
                    .createNamedQuery("Doctor.findByName", Doctor.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(doctor).build();
    }
}
