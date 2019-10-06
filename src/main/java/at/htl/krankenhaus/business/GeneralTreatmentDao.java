package at.htl.krankenhaus.business;

import at.htl.krankenhaus.model.GeneralTreatment;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneralTreatmentDao extends AbstractDao<GeneralTreatment> {
    public GeneralTreatmentDao() {
        super(GeneralTreatment.class, "GeneralTreatment.findAll");
    }
}
