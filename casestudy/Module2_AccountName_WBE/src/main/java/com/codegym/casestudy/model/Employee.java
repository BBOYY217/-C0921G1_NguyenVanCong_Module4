package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String employeeName;
    private String employeeBirth;
    private String employeeIdCard;
    private String employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @OneToMany(mappedBy = "positionId")
    private List<Position> positionId;

    @OneToMany(mappedBy = "educationDegreeId")
    private List<EducationDegree> educationDegreeId;

    @OneToMany(mappedBy = "divisionId")
    private List<Division> divisionId;

//    @OneToOne(mappedBy = "username")
//    private User username;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeBirth, String employeeIdCard, String employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, List<Position> positionId, List<EducationDegree> educationDegreeId, List<Division> divisionId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirth = employeeBirth;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
//        this.username = username;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirth() {
        return employeeBirth;
    }

    public void setEmployeeBirth(String employeeBirth) {
        this.employeeBirth = employeeBirth;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public List<Position> getPositionId() {
        return positionId;
    }

    public void setPositionId(List<Position> positionId) {
        this.positionId = positionId;
    }

    public List<EducationDegree> getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(List<EducationDegree> educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public List<Division> getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(List<Division> divisionId) {
        this.divisionId = divisionId;
    }
//
//    public User getUsername() {
//        return username;
//    }
//
//    public void setUsername(User username) {
//        this.username = username;
//    }
}
