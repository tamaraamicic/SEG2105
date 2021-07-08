package com.example.seg2105_term_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class StudentEnroll extends AppCompatActivity {

    TextInputEditText inputNameForEnroll;
    TextInputEditText inputCodeForEnroll;
    TextInputEditText inputDateForEnroll;
    Button searchButtonForEnroll;
    Button enrollButtonForEnroll;
    MyDBHandlerCourses myDBHandlerCourses;
    Course course;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_enroll);

        getSupportActionBar().setTitle("Course Enrollment");

        inputNameForEnroll = (TextInputEditText) (findViewById(R.id.inputNameForEnroll));
        inputCodeForEnroll = (TextInputEditText) (findViewById(R.id.inputCodeForEnroll));
        inputDateForEnroll = (TextInputEditText) (findViewById(R.id.inputDateForEnroll));
        searchButtonForEnroll = (Button) (findViewById(R.id.searchButtonForEnroll));
        enrollButtonForEnroll = (Button) (findViewById(R.id.enrollButtonForEnroll));
        myDBHandlerCourses = new MyDBHandlerCourses(this);
        searchButtonForEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputNameForEnroll.getText().toString();
                String code = inputCodeForEnroll.getText().toString();
                course = myDBHandlerCourses.findCourse(name, code);
                if (course != null) {
                    if (code.equals("")) {
                        inputCodeForEnroll.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForEnroll.setText(course.getCourseName());
                    }
                    if (course.hasStudent(CurrentUser.getUsername())){
                        AlertDialog.Builder builder = new AlertDialog.Builder(StudentEnroll.this);
                        builder.setMessage("You are already enrolled in this course!").setTitle("Notice");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        boolean flag = false;
                        Cursor cursor = myDBHandlerCourses.viewData();
                        while (cursor.moveToNext()) {
                            Course course = myDBHandlerCourses.findCourse(cursor.getString(1),cursor.getString(2));
                            if(course.hasStudent(CurrentUser.getUsername())){
                                if(!course.getTime1().equals("") && !course.getTime2().equals("")){
                                    if(course.getDate1().equals(course.getDate1())){
                                        if(course.getTime1().equals(course.getTime1())){
                                            flag = true;
                                            break;
                                        }
                                    }else if(course.getDate2().equals(course.getDate2())){
                                        if(course.getTime2().equals(course.getTime2())){
                                            flag = true;
                                            break;
                                        }
                                    }
                            }

                        }
                        }
                        if(flag){
                            AlertDialog.Builder builder = new AlertDialog.Builder(StudentEnroll.this);
                            builder.setMessage("This course timings interferes with your other courses!").setTitle("Warning");
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(StudentEnroll.this);
                            builder.setMessage("This course is open! You may enroll yourself in it").setTitle("Notice");
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            enrollButtonForEnroll.setEnabled(true);
                        }
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });

        enrollButtonForEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StudentEnroll.this);
                course.addStudent(CurrentUser.getUsername());
                addCourseAgain(course);
                builder.setMessage("Successfully enrolled!").setTitle("Done");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
    public Course addCourseAgain(Course course){
        String courseName = course.getCourseName();
        String courseCode = course.getCourseCode();
        String allStudents = course.getStudents();
        myDBHandlerCourses.deleteCourse(courseName,courseCode);
        Course newCourse = new Course(courseName,courseCode);
        newCourse.setCourseName(courseName);
        newCourse.setCourseCode(courseCode);
        newCourse.setInstructor(course.getInstructor());
        newCourse.setDate1(course.getDate1());
        newCourse.setDate2(course.getDate2());
        newCourse.setTime1(course.getTime1());
        newCourse.setTime2(course.getTime2());
        newCourse.setCapacity(course.getCapacity());
        newCourse.setDescription(course.getDescription());
        newCourse.setStudents(allStudents);
        myDBHandlerCourses.addCourse(newCourse);
        return newCourse;
    }
}
