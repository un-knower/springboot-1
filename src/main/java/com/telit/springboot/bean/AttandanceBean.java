package com.telit.springboot.bean;

import java.io.Serializable;

public class AttandanceBean implements Serializable{
    private String studentName;
    private String photo;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {

        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStudentName() {

        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
