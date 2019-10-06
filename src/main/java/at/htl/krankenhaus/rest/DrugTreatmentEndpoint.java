package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.business.DrugTreatmentDao;
import at.htl.krankenhaus.model.Doctor;
import at.htl.krankenhaus.model.DrugTreatment;
import at.htl.krankenhaus.model.Patient;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("drugtreatment")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class DrugTreatmentEndpoint extends AbstractEndpoint<DrugTreatment, DrugTreatmentDao> {

    /*@POST
    public Long putDrugTreatment(DrugTreatment treatment) {
        Doctor doctor = treatment.getDoctor();
        Patient patient = treatment.getPatient();

        em.merge(doctor);
        em.persist(doctor);
        em.merge(patient);
        em.persist(patient);

        em.persist(treatment);
        return treatment.getId();
    }*/
}
