package com.eil.Entities;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "EIL_FOLDER_TEMPLATES")
public class EILFolderTemplates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATEID")
    private String templateId;

    @Column(name = "CREATIONDATE", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp creationDate;

    @Column(name = "TMPLFOLDERID")
    private String tmplFolderId;

    @Column(name = "TMPLFOLDERNAME")
    private String tmplFolderName;

    @Column(name = "TMPLPARENTFOLDERID")
    private String tmplParentFolderId;

    @Column(name = "STATICFLAG", columnDefinition = "INT DEFAULT 1")
    private int staticFlag;

    @Column(name = "PROJECTFLAG", columnDefinition = "INT DEFAULT 1")
    private int projectFlag;

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

    public int getStaticFlag() {
        return staticFlag;
    }

    public void setStaticFlag(int staticFlag) {
        this.staticFlag = staticFlag;
    }

    public int getProjectFlag() {
        return projectFlag;
    }

    public void setProjectFlag(int projectFlag) {
        this.projectFlag = projectFlag;
    }
}
