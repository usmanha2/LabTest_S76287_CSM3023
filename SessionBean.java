package com.drivesmart.model;

import java.io.Serializable;

public class SessionBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Private variables 
    private int sessionId;
    private String studentName;
    private String branchLocation;
    private String lessonType;
    private String status;

    // Empty constructor 
    public SessionBean() {
    }

    // Parameterized constructor 
    public SessionBean(String studentName, String branchLocation, String lessonType, String status) {
        this.studentName = studentName;
        this.branchLocation = branchLocation;
        this.lessonType = lessonType;
        this.status = status;
    }

    // Standard getters and setters 
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }
}