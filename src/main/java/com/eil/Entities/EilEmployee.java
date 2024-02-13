package com.eil.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eil_employee")
public class EilEmployee {

    public EilEmployee(Long employeeId, String firstName, String lastName, Integer age, Date dateOfBirth, EILDiscipline department, String password) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeId")
    private Long employeeId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="age")
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name="dateOfBirth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "departmentID", referencedColumnName = "departmentID")
    private EILDiscipline department;


    @Column(name="password")
    private String password;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EILDiscipline getDepartment() {
        return department;
    }

    public void setDepartment(EILDiscipline department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
