package com.example.controller.models;

public class SubmissionControllerModel {

    private Long idassignuser;

    private int grade;

    private String gitrepo;

    private String remark;

    private Long iduser;

    private String emailUser;



    private Long idassignment;

    public SubmissionControllerModel() {
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

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Long getIdassignment() {
        return idassignment;
    }

    public void setIdassignment(Long idassignment) {
        this.idassignment = idassignment;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}
