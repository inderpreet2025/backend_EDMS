package com.eil.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EIL_DISCIPLINE")
public class EILDiscipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISCIPLINEID")
    private String id;


    @Column(name = "DIVISIONID")
    private int divisionId;

    @Column(name = "DEPARTMENTID")
    private int departmentId;

    @Column(name = "DIVISIONNAME")
    private String divisionName;

    @Column(name = "DEPARTMENTNAME")
    private String departmentName;

    @Column(name = "TEMPLATEID")
    private String templateId;

    @Column(name = "DISCONTINUED")
    private boolean discontinued;

    @Column(name = "DONTWORKINEDMS")
    private boolean dontWorkInEDMS;

    @Column(name = "SHORTNAME")
    private String shortName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public boolean isDontWorkInEDMS() {
        return dontWorkInEDMS;
    }

    public void setDontWorkInEDMS(boolean dontWorkInEDMS) {
        this.dontWorkInEDMS = dontWorkInEDMS;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
