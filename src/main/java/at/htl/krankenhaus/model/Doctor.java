package at.htl.krankenhaus.model;


import javax.persistence.*;

enum A {
    A
    ,B,C
}

@Entity
@NamedQueries({
        @NamedQuery(name = "Doctor.findAll", query = "select d from Doctor d"),
        @NamedQuery(name = "Doctor.findByName", query = "select d from Doctor d where d.name = :name")
})
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    @Enumerated(value = EnumType.STRING)
    private A test;

    public Doctor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Doctor() {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
