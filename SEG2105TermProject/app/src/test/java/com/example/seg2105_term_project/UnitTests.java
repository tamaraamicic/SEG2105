package com.example.seg2105_term_project;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTests {





    @Test
    public void instructorIsCorrect() {
        Course course = new Course("Introduction to Software Engineering", "SEG2105");
        course.setInstructor("Omar Badreddin");
        assertEquals(course.getInstructor(), "Omar Badreddin");
    }

    @Test
    public void noDate1() {
        Course course = new Course("Introduction to Software Engineering", "SEG2105");
        assertEquals(course.getCapacity(), 0);
    }

    @Test
    public void roleIsCorrect() {
        CurrentUser.setRole("student");
        assertEquals(CurrentUser.getRole(), "student");
    }

    @Test
    public void usernameIsCorrect() {
        User user = new User("tamara", "tamara123");
        assertEquals(user.getUsername(), "tamara");
    }

    @Test
    public void passwordIsCorrect() {
        User user = new User("teodora", "teodora123");
        assertEquals(user.getPassword(), "teodora123");
    }

    @Test
    public void getStudentsNoStudents() {
        Course course = new Course("Data Structures and Algorithms", "CSI2110");
        assertEquals(course.getStudents(), "");
    }

    @Test
    public void addStudentsIsCorrect() {
        Course course = new Course("History", "HIS101");
        course.addStudent("Student1");
        course.addStudent("Student2");
        assertEquals(course.getStudents(), "Student1, Student2, ");
    }

    @Test
    public void removeStudentIsCorrect() {
        Course course = new Course("Psychology", "PSY101");
        course.removeStudent("Student1");
        assertEquals(course.getStudents(), "");
    }

    @Test
    public void setStudentIsCorrect() {

    }

    @Test void hasStudentIsCorrect() {

    }

}
