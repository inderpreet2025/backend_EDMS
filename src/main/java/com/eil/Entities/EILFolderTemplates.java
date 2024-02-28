package com.eil.Entities;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EIL_FOLDER_TEMPLATES")
public class EILFolderTemplates {
    @Id
    @Column(name = "TEMPLATEID", nullable = false, length = 16)
    private int templateId;

    @Column(name = "CREATIONDATE", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creationDate;

    @Column(name = "TMPLFOLDERID")
    private int tmplFolderId;

    @Column(name = "TMPLFOLDERNAME", length = 500)
    private String tmplFolderName;

    @Column(name = "TMPLPARENTFOLDERID")
    private int tmplParentFolderId;

    @Column(name = "STATICFLAG", columnDefinition = "INT DEFAULT 1")
    private Integer staticFlag;

    @Column(name = "PROJECTFLAG", columnDefinition = "INT DEFAULT 1")
    private Integer projectFlag;

    public EILFolderTemplates() {
        // Default constructor
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getTmplFolderId() {
        return tmplFolderId;
    }

    public void setTmplFolderId(int tmplFolderId) {
        this.tmplFolderId = tmplFolderId;
    }

    public String getTmplFolderName() {
        return tmplFolderName;
    }

    public void setTmplFolderName(String tmplFolderName) {
        this.tmplFolderName = tmplFolderName;
    }

    public int getTmplParentFolderId() {
        return tmplParentFolderId;
    }

    public void setTmplParentFolderId(int tmplParentFolderId) {
        this.tmplParentFolderId = tmplParentFolderId;
    }

    public Integer getStaticFlag() {
        return staticFlag;
    }

    public void setStaticFlag(Integer staticFlag) {
        this.staticFlag = staticFlag;
    }

    public Integer getProjectFlag() {
        return projectFlag;
    }

    public void setProjectFlag(Integer projectFlag) {
        this.projectFlag = projectFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EILFolderTemplates that = (EILFolderTemplates) o;
        return Objects.equals(templateId, that.templateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateId);
    }

    @Override
    public String toString() {
        return "EILFolderTemplates{" +
                "templateId='" + templateId + '\'' +
                ", creationDate=" + creationDate +
                ", tmplFolderId='" + tmplFolderId + '\'' +
                ", tmplFolderName='" + tmplFolderName + '\'' +
                ", tmplParentFolderId='" + tmplParentFolderId + '\'' +
                ", staticFlag=" + staticFlag +
                ", projectFlag=" + projectFlag +
                '}';
    }

}
