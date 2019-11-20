package at.htl.krankenhaus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Often, multiple diagnoses are needed for a certain treatment (X-Ray, MRT, ..)
// One diagnose can result in multiple treatments
@Entity
public abstract class Treatment extends PanacheEntity {
    public String name;
    @ManyToOne
    public Doctor doctor;
    @ManyToOne
    public Patient patient;
    // Doctors tend to write down quite a bunch of things
    public String outcome;
    public LocalDate startDate;
    public LocalDate endDate;
    // A treatment is justified by 1+ diagnoses. 1 diagnose can result in multiple treatments
    @ManyToMany
    public List<Diagnosis> diagnoses = new ArrayList<>();

    public Treatment() {
    }

    public Treatment(String name, Doctor doctor, Patient patient, String outcome, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.doctor = doctor;
        this.patient = patient;
        this.outcome = outcome;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
