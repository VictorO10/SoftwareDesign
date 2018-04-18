package com.example.model.dao.models;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="laboratories")
public class LaboratoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idlaboratory")
    private Long idlaboratory;

    @Column(name = "lab_nb")
    private Long labNb;

    @Column(name="date_of_lab")
    private Date dateOfLab;

    @Column(name="title")
    private String title;

    @Column(name="curricula")
    private String curricula;

    @Column(name="long_description")
    private String longDescription;

    @OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "laboratoryModel")
    private Set<AssignmentModel> assignments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "laboratoryModelAtt")
    private Set<AttendanceModel> attendances = new HashSet<>();

    public LaboratoryModel(){
    }

    public LaboratoryModel(Long idlaboratory, Long labNb, Date dateOfLab, String title, String curricula, String longDescription) {
        this.idlaboratory = idlaboratory;
        this.labNb = labNb;
        this.dateOfLab = dateOfLab;
        this.title = title;
        this.curricula = curricula;
        this.longDescription = longDescription;
    }

    public LaboratoryModel(Long idlaboratory, Long labNb, Date dateOfLab, String title, String curricula, String longDescription, Set<AssignmentModel> assignments) {
        this.idlaboratory = idlaboratory;
        this.labNb = labNb;
        this.dateOfLab = dateOfLab;
        this.title = title;
        this.curricula = curricula;
        this.longDescription = longDescription;
        this.assignments = assignments;
    }

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

    public Set<AssignmentModel> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<AssignmentModel> assignments) {
        this.assignments = assignments;
    }

    public Set<AttendanceModel> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<AttendanceModel> attendances) {
        this.attendances = attendances;
    }
}
