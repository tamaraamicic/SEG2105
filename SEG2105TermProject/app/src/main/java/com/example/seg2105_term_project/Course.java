package com.example.seg2105_term_project;

public class Course {

    String name;
    String code;
    private int id;

    Course(String name, String code) {
        this.name = name;
        this.code = code;
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
