package com.example.model.dao.models;

import javax.persistence.*;

@Entity
@Table(name="attendance")
public class AttendanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idattendance")
    private Long idattendance;

    @Column(name = "bonus_points")
    private int bonusPoints;

    @ManyToOne
    @JoinColumn(name = "iduser_att", nullable = true)
    private UserModel userModelAtt;

    @ManyToOne
    @JoinColumn(name = "idlaboratory_att", nullable = true)
    private LaboratoryModel laboratoryModelAtt;

    public AttendanceModel() {
    }

    public Long getIdattendance() {
        return idattendance;
    }

    public void setIdattendance(Long idattendance) {
        this.idattendance = idattendance;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public UserModel getUserModelAtt() {
        return userModelAtt;
    }

    public void setUserModelAtt(UserModel userModelAtt) {
        this.userModelAtt = userModelAtt;
    }

    public LaboratoryModel getLaboratoryModelAtt() {
        return laboratoryModelAtt;
    }

    public void setLaboratoryModelAtt(LaboratoryModel laboratoryModelAtt) {
        this.laboratoryModelAtt = laboratoryModelAtt;
    }


}
