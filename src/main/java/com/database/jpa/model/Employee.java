package com.database.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "occupation")
    private String occupation;

    public Employee(Long id, String name, String occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Occupations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
