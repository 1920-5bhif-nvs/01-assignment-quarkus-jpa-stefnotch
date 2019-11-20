package at.htl.krankenhaus.rest;

import at.htl.krankenhaus.model.DrugTreatment;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("drugtreatment")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional
public class DrugTreatmentEndpoint extends AbstractEndpoint<DrugTreatment> {

}
