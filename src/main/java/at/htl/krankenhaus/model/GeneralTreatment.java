package at.htl.krankenhaus.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

@Entity
public class GeneralTreatment extends Treatment {
    public String treatmentInformation;

    public GeneralTreatment(String name, Doctor doctor, Patient patient, String outcome, LocalDate startDate, LocalDate endDate, String treatmentInformation) {
        super(name, doctor, patient, outcome, startDate, endDate);
        this.treatmentInformation = treatmentInformation;
    }

    public GeneralTreatment() {
    }
}
