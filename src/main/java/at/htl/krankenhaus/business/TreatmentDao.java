package at.htl.krankenhaus.business;

import at.htl.krankenhaus.model.Treatment;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TreatmentDao extends AbstractDao<Treatment> {
    public  TreatmentDao() {
        super(Treatment.class, "Treatment.findAll");
    }
}
