package hello.models;

public class AssignmentSubmissionWUserAndLab {
    private Long idassignuser;

    private int grade;

    private String gitrepo;

    private String remark;

    private Long iduser;

    private Long idassignment;

    private User user;

    private Assignment assignment;

    public AssignmentSubmissionWUserAndLab() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "AssignmentSubmissionWUaL{" +
                "idsubmission=" + idassignuser +
                ", grade='" + grade + '\'' +
                ", gitRepo='" + gitrepo + '\'' +
                ", remark='" + remark + '\'' +
                ", iduser='" + iduser + '\'' +
                ", idAssignment='" + idassignment + '\'' +
                ", userFullName='" + user.getFullName() + '\'' +
                ", assignName='" + assignment.getName() + '\'' +
                '}';
    }
}
