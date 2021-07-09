package com.example.seg2105_term_project;

import java.util.ArrayList;

public class Course {

    String name;
    String code;
    private int id;
    private String instructor;
    private String date1;
    private String date2;
    private String time1;
    private String time2;
    private int capacity;
    private String description;
    private String students;
    Course(String name, String code) {
        this.name = name;
        this.code = code;
        this.date1 = "";
        this.date2 = "";
        this.time1 = "";
        this.time2 = "";
        this.capacity = 0;
        this.description = "";
        this.instructor = "";
        this.students = "";
    }

    public void setInstructor(String instructor){
        this.instructor = instructor;
    }

    public String getInstructor() {
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

    public void setDate1(String date1){
        this.date1 = date1;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getDate1() {
        return date1;
    }

    public String getDate2() {
        return date2;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return this.capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void addStudent(String studentName){
        students+=" "+studentName+", ";
    }
    public void removeStudent(String studentName){


        String[] temp = students.split(", ");
        students = "";
        for (int i = 0; i < temp.length; i++){
            if(!temp[i].replace(",","").equals(studentName)){
                students+=temp[i].replace(",","")+", ";
            }
        }


    }
    public String getStudents(){
        return this.students.trim();
    }

    //USE ONLY FOR DEBUGGING
    public void setStudents(String allStudents){
        this.students = allStudents;
    }
    //USE ONLY FOR DEBUGGING
    public void removeAllStudents(){
        students = "";
    }
    public boolean hasStudent(String studentName){
        if(students.length()!=0){
            String[] temp = students.split(", ");
            for (int i = 0; i < temp.length; i++){
                if(temp[i].replace(",","").equals(studentName)){

                    return true;
                }
            }
        }

        return false;
    }
}
