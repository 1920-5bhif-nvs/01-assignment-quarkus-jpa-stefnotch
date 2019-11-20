package at.htl.krankenhaus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient extends PanacheEntity {
    public String name;
    public LocalDate birthdate;

    @OneToMany(mappedBy = "patient")
    @JsonbTransient
    public List<Treatment> treatments = new ArrayList<>();

    @OneToMany(mappedBy = "patient")
    @JsonbTransient
    public List<Diagnosis> diagnoses = new ArrayList<>();

    public Patient() {
    }

    public Patient(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
}
