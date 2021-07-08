package com.example.seg2105_term_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class StudentUnenroll extends AppCompatActivity {

    TextInputEditText inputNameForUnenroll;
    TextInputEditText inputCodeForUnenroll;
    TextInputEditText inputDateForUnenroll;
    Button searchButtonForUnenroll;
    Button unenrollButtonForUnenroll;
    Course course;
    MyDBHandlerCourses myDBHandlerCourses;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_unenroll);
        getSupportActionBar().setTitle("Course Un-Enrollment");

        inputNameForUnenroll = (TextInputEditText) (findViewById(R.id.inputNameForUnenroll));
        inputCodeForUnenroll = (TextInputEditText) (findViewById(R.id.inputCodeForUnenroll));
        inputDateForUnenroll = (TextInputEditText) (findViewById(R.id.inputDateForUnenroll));
        searchButtonForUnenroll = (Button) (findViewById(R.id.searchButtonForUnenroll));
        unenrollButtonForUnenroll = (Button) (findViewById(R.id.unenrollButtonForUnenroll));
        myDBHandlerCourses = new MyDBHandlerCourses(this);
        searchButtonForUnenroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputNameForUnenroll.getText().toString();
                String code = inputCodeForUnenroll.getText().toString();
                course = myDBHandlerCourses.findCourse(name, code);
                if (course != null) {
                    if (code.equals("")) {
                        inputCodeForUnenroll.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForUnenroll.setText(course.getCourseName());
                    }
                    if (course.hasStudent(CurrentUser.getUsername())){
                        AlertDialog.Builder builder = new AlertDialog.Builder(StudentUnenroll.this);
                        builder.setMessage("You are enrolled in this course. Press the unenroll button.").setTitle("Notice");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(StudentUnenroll.this);
                        builder.setMessage("You are not enrolled in this course").setTitle("Notice");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        unenrollButtonForUnenroll.setEnabled(true);
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });

        unenrollButtonForUnenroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StudentUnenroll.this);
                course.removeStudent(CurrentUser.getUsername());
                addCourseAgain(course);
                builder.setMessage("Successfully unenrolled!").setTitle("Done");
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
