package com.example.model.service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class AssignmentDTO implements Serializable{


    private Long idassignment;

    private String name;


    private Date deadline;

    private String longDescription;

    private Long idlaboratory;

//    private LaboratoryDTO laboratoryDTO;


    public AssignmentDTO(){
    }

    @JsonIgnore
    public Long getIdassignment() {
        return idassignment;
    }

    @JsonIgnore
    public void setIdassignment(Long idassignment) {
        this.idassignment = idassignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Long getIdlaboratory() {
        return idlaboratory;
    }

    public void setIdlaboratory(Long idlaboratory) {
        this.idlaboratory = idlaboratory;
    }

    //    public LaboratoryDTO getLaboratoryDTO() {
//        return laboratoryDTO;
//    }
//
//    public void setLaboratoryDTO(LaboratoryDTO laboratoryDTO) {
//        this.laboratoryDTO = laboratoryDTO;
//    }
}
