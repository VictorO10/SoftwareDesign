package com.example.controller.models;

public class UserControllerModel {

    private String fullName;

    private String email;

    private String password;

    private String groupName;

    private String hobby;

    private boolean teacher;

    private String token;

    public UserControllerModel(String fullName, String email, String password, String groupName, String hobby, boolean teacher, String token) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.groupName = groupName;
        this.hobby = hobby;
        this.teacher = teacher;
        this.token = token;
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

    @Override
    public String toString() {
        return "UserModel{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", groupName='" + groupName + '\'' +
                ", hobby='" + hobby + '\'' +
                ", teacher='" + teacher + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

