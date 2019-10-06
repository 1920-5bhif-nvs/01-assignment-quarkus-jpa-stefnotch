package at.htl.krankenhaus.business;

import at.htl.krankenhaus.model.DrugTreatment;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DrugTreatmentDao extends AbstractDao<DrugTreatment> {
    public DrugTreatmentDao() {
        super(DrugTreatment.class, "DrugTreatment.findAll");
    }
}
