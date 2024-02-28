package com.eil.Entities;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EIL_FOLDER_TEMPLATES")
public class EILFolderTemplates {
    @Id
    @Column(name = "TEMPLATEID", nullable = false, length = 16)
    private String templateId;

    @Column(name = "CREATIONDATE", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creationDate;

    @Column(name = "TMPLFOLDERID")
    private String tmplFolderId;

    @Column(name = "TMPLFOLDERNAME", length = 500)
    private String tmplFolderName;

    @Column(name = "TMPLPARENTFOLDERID")
    private String tmplParentFolderId;

    @Column(name = "STATICFLAG", columnDefinition = "INT DEFAULT 1")
    private Integer staticFlag;

    @Column(name = "PROJECTFLAG", columnDefinition = "INT DEFAULT 1")
    private Integer projectFlag;

    public EILFolderTemplates() {
        // Default constructor
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getTmplFolderId() {
        return tmplFolderId;
    }

    public void setTmplFolderId(String tmplFolderId) {
        this.tmplFolderId = tmplFolderId;
    }

    public String getTmplFolderName() {
        return tmplFolderName;
    }

    public void setTmplFolderName(String tmplFolderName) {
        this.tmplFolderName = tmplFolderName;
    }

    public String getTmplParentFolderId() {
        return tmplParentFolderId;
    }

    public void setTmplParentFolderId(String tmplParentFolderId) {
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
