package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.GeneralTreatment;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("generaltreatment")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class GeneralTreatmentEndpoint extends AbstractEndpoint<GeneralTreatment> {

}
