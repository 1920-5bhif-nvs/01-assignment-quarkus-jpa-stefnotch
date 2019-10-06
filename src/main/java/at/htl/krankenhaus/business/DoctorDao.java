package at.htl.krankenhaus.business;

import at.htl.krankenhaus.model.Doctor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctorDao extends AbstractDao<Doctor> {
    public DoctorDao() {
        super(Doctor.class, "Doctor.findAll");
    }
}
