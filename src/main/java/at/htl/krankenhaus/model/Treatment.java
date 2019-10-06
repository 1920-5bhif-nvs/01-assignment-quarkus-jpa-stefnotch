package at.htl.krankenhaus.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Often, multiple diagnoses are needed for a certain treatment (X-Ray, MRT, ..)
// One diagnose can result in multiple treatments
@Entity
@NamedQueries({
        @NamedQuery(name = "Treatment.findAll", query = "select t from Treatment t")
})
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    private String outcome; // Doctors tend to write down quite a bunch of things

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany//(mappedBy = "treatments")
    private List<Diagnosis> diagnoses = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
