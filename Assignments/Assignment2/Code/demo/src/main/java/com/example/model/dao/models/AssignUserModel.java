package com.example.model.dao.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="assignuser")
public class AssignUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idassignuser")
    private Long idassignuser;

    @Column(name = "grade")
    private int grade;

    @Column(name = "gitrepo")
    private String gitrepo;

    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = true)
    private UserModel userModelGrade;

    @ManyToOne
    @JoinColumn(name = "idassignment", nullable = true)
    private AssignmentModel assignmentModelGrade;

    public AssignUserModel() {
    }

    public Long getIdassignuser() {
        return idassignuser;
    }

    public void setIdassignuser(Long idassignuser) {
        this.idassignuser = idassignuser;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGitrepo() {
        return gitrepo;
    }

    public void setGitrepo(String gitrepo) {
        this.gitrepo = gitrepo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UserModel getUserModelGrade() {
        return userModelGrade;
    }

    public void setUserModelGrade(UserModel userModelGrade) {
        this.userModelGrade = userModelGrade;
    }

    public AssignmentModel getAssignmentModelGrade() {
        return assignmentModelGrade;
    }

    public void setAssignmentModelGrade(AssignmentModel assignmentModelGrade) {
        this.assignmentModelGrade = assignmentModelGrade;
    }


}
