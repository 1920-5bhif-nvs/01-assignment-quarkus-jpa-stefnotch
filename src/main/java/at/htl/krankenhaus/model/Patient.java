package at.htl.krankenhaus.model;

import at.htl.krankenhaus.LocalDateAdapter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Patient.findAll", query = "select p from Patient p")
})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthdate;

    @JsonIgnore
    @JsonbTransient
    @OneToMany(mappedBy = "patient")
    private List<Treatment> treatments = new ArrayList<>();

    public Patient() {
    }

    public Patient(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
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


    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
