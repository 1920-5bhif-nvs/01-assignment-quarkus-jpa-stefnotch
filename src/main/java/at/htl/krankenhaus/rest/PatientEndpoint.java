package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.business.PatientDao;
import at.htl.krankenhaus.model.Patient;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("patient")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PatientEndpoint extends AbstractEndpoint<Patient, PatientDao> {

}
