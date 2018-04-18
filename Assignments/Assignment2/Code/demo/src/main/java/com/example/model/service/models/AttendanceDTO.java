package com.example.model.service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AttendanceDTO {

    private Long idattendance;

    private int bonusPoints;

    private Long iduser;

    private Long idlaboratory;

    public AttendanceDTO() {
    }

    @JsonIgnore
    public Long getIdattendance() {
        return idattendance;
    }

    @JsonIgnore
    public void setIdattendance(Long idattendance) {
        this.idattendance = idattendance;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Long getIdlaboratory() {
        return idlaboratory;
    }

    public void setIdlaboratory(Long idlaboratory) {
        this.idlaboratory = idlaboratory;
    }
}
