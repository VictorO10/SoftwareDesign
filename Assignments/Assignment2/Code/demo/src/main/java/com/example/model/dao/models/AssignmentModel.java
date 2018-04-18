package com.example.model.dao.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assignments")
public class AssignmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idassignment")
    private Long idassignment;

    @Column(name="name")
    private String name;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="long_description")
    private String longDescription;

    @ManyToOne
    @JoinColumn(name = "idlaboratory", nullable = true)
    private LaboratoryModel laboratoryModel;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "assignmentModelGrade")
    private Set<AssignUserModel> grades = new HashSet<>();

    public AssignmentModel() {
    }

    public AssignmentModel(Long idassignment, String name, Date deadline, String longDescription, LaboratoryModel laboratoryModel) {
        this.idassignment = idassignment;
        this.name = name;
        this.deadline = deadline;
        this.longDescription = longDescription;
        this.laboratoryModel = laboratoryModel;
    }

    public Long getIdassignment() {
        return idassignment;
    }

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

    public LaboratoryModel getLaboratoryModel() {
        return laboratoryModel;
    }

    public void setLaboratoryModel(LaboratoryModel laboratoryModel) {
        this.laboratoryModel = laboratoryModel;
    }

    public Set<AssignUserModel> getGrades() {
        return grades;
    }

    public void setGrades(Set<AssignUserModel> grades) {
        this.grades = grades;
    }
}
