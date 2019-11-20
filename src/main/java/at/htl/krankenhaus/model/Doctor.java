package at.htl.krankenhaus.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Doctor extends PanacheEntity {
    public String name;
    public double salary;

    @OneToMany(mappedBy = "doctor")
    @JsonbTransient
    public List<Treatment> treatments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor")
    @JsonbTransient
    public List<Diagnosis> diagnoses = new ArrayList<>();

    public Doctor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Doctor() {
    }

    public static Doctor findByName(String name) {
        return find("name", name).firstResult();
    }
}
