package com.example.model.service.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class LaboratoryDTO implements Serializable{

    private Long idlaboratory;

    private Long labNb;

    private Date dateOfLab;

    private String title;

    private String curricula;

    private String longDescription;

//    private Set<AssignmentDTO> assignments = new HashSet<>();

    public LaboratoryDTO() {
    };

    public LaboratoryDTO(Long idlaboratory, Long labNb, Date dateOfLab, String title, String curricula, String longDescription) {
        this.idlaboratory = idlaboratory;
        this.labNb = labNb;
        this.dateOfLab = dateOfLab;
        this.title = title;
        this.curricula = curricula;
        this.longDescription = longDescription;
    }

//    public LaboratoryDTO(Long idlaboratory, Long labNb, Date dateOfLab, String title, String curricula, String longDescription, Set<AssignmentDTO> assignments) {
//        this.idlaboratory = idlaboratory;
//        this.labNb = labNb;
//        this.dateOfLab = dateOfLab;
//        this.title = title;
//        this.curricula = curricula;
//        this.longDescription = longDescription;
//        this.assignments = assignments;
//    }

    public Long getIdlaboratory() {
        return idlaboratory;
    }

    public void setIdlaboratory(Long idlaboratory) {
        this.idlaboratory = idlaboratory;
    }

    public Long getLabNb() {
        return labNb;
    }

    public void setLabNb(Long labNb) {
        this.labNb = labNb;
    }

    public Date getDateOfLab() {
        return dateOfLab;
    }

    public void setDateOfLab(Date dateOfLab) {
        this.dateOfLab = dateOfLab;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

//    public Set<AssignmentDTO> getAssignments() {
//        return assignments;
//    }
//
//    public void setAssignments(Set<AssignmentDTO> assignments) {
//        this.assignments = assignments;
//    }
}
