package com.example.model.dao.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iduser")
    private Long iduser;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "is_teacher")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean teacher;

    @Column(name = "token")
    private String token;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "userModelGrade")
    private Set<AssignUserModel> grades = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "userModelAtt")
    private Set<AttendanceModel> attendances = new HashSet<>();

    public UserModel() {
    }

    public UserModel(Long iduser, String fullName, String email, String password, String groupName, String hobby, boolean teacher, String token) {
        this.iduser = iduser;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.groupName = groupName;
        this.hobby = hobby;
        this.teacher = teacher;
        this.token = token;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean isTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<AssignUserModel> getGrades() {
        return grades;
    }

    public void setGrades(Set<AssignUserModel> grades) {
        this.grades = grades;
    }

    public Set<AttendanceModel> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<AttendanceModel> attendances) {
        this.attendances = attendances;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "iduser=" + iduser +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", groupName='" + groupName + '\'' +
                ", hobby='" + hobby + '\'' +
                ", isTeacher='" + teacher + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
