package com.codegym.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "educationDegree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int educationDegreeId;
    private String educationDegreeName;

    public EducationDegree() {
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
