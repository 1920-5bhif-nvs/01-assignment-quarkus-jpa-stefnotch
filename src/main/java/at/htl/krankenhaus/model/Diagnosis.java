package at.htl.krankenhaus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Diagnosis extends PanacheEntity {
    @ManyToOne
    public Doctor doctor;
    @ManyToOne
    public Patient patient;
    public String diagnose;
    public LocalDate diagnosisDate;

    @ManyToMany(mappedBy = "diagnoses")
    public List<Treatment> treatments = new ArrayList<>();

    public Diagnosis() {

    }

    public Diagnosis(Doctor doctor, Patient patient, String diagnose, LocalDate diagnosisDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.diagnose = diagnose;
        this.diagnosisDate = diagnosisDate;
    }
}
