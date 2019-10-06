package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.business.GeneralTreatmentDao;
import at.htl.krankenhaus.model.Doctor;
import at.htl.krankenhaus.model.DrugTreatment;
import at.htl.krankenhaus.model.GeneralTreatment;
import at.htl.krankenhaus.model.Patient;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("generaltreatment")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class GeneralTreatmentEndpoint extends AbstractEndpoint<GeneralTreatment, GeneralTreatmentDao> {

    /*
    @POST
    public Long putGeneralTreatment(GeneralTreatment treatment) {
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
