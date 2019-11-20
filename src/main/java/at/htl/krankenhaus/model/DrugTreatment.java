package at.htl.krankenhaus.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

@Entity
public class DrugTreatment extends Treatment {
    public String drugName;
    public double dosePerDay;

    public DrugTreatment(String name, Doctor doctor, Patient patient, String outcome, LocalDate startDate, LocalDate endDate, String drugName, double dosePerDay) {
        super(name, doctor, patient, outcome, startDate, endDate);
        this.drugName = drugName;
        this.dosePerDay = dosePerDay;
    }

    public DrugTreatment() {
    }
}
