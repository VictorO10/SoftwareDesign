package hello.models;

public class AttendanceWUserAndLab {

    private Long idattendance;

    private int bonusPoints;

    private Long iduser;

    private Long idlaboratory;

    private User user;

    private LaboratoryWAssignments laboratory;

    public AttendanceWUserAndLab() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LaboratoryWAssignments getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(LaboratoryWAssignments laboratory) {
        this.laboratory = laboratory;
    }
}
