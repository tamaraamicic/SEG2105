package com.example.seg2105_term_project;

public class Course {

    String name;
    String code;
    private int id;
    private User instructor;
    Course(String name, String code) {
        this.name = name;
        this.code = code;
        this.instructor = null;
    }

    public void setInstructor(User instructor){
        this.instructor = instructor;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setID(int id){
        this.id=id;
    }

    public void setCourseName(String name){
        this.name = name;
    }

    public void setCourseCode(String code){
        this.code = code;
    }

    public String getCourseName() {
        return name;
    }

    public String getCourseCode() {
        return code;
    }
}
