package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.Patient;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("patient")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class PatientEndpoint extends AbstractEndpoint<Patient> {

}
