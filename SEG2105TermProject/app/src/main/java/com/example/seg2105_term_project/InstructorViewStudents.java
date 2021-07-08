package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InstructorViewStudents extends AppCompatActivity {

    TextInputEditText inputNameForInstructorViewStudents;
    TextInputEditText inputCodeInstructorViewStudents;
    Button searchButtonForInstructorViewStudents;
    Button viewStudentsForInstructorViewStudents;
    Course course;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_view_students);

        inputNameForInstructorViewStudents = (TextInputEditText) (findViewById(R.id.inputNameForInstructorViewStudents));
        inputCodeInstructorViewStudents = (TextInputEditText) (findViewById(R.id.inputCodeInstructorViewStudents));
        searchButtonForInstructorViewStudents = (Button)(findViewById(R.id.searchButtonForInstructorViewStudents));
        viewStudentsForInstructorViewStudents = (Button)(findViewById(R.id.viewStudentsForInstructorViewStudents));
        viewStudentsForInstructorViewStudents.setEnabled(false);

        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        searchButtonForInstructorViewStudents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForInstructorViewStudents.getText().toString();
                String code = inputCodeInstructorViewStudents.getText().toString();
                course = handlerCourses.findCourse(name, code);
                if (course != null) {
                    if (code.equals("")) {
                        inputCodeInstructorViewStudents.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForInstructorViewStudents.setText(course.getCourseName());
                    }
                    if (course.getInstructor().equals(CurrentUser.getUsername())) {
                        Toast toast = Toast.makeText(getApplicationContext(), "You teach this course! You may view the students.", Toast.LENGTH_LONG);
                        toast.show();
                        viewStudentsForInstructorViewStudents.setEnabled(true);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "You do not teach this course. Please retry.", Toast.LENGTH_LONG);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        viewStudentsForInstructorViewStudents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InstructorViewStudentsPart2.class);
                intent.putExtra("mainCourse",course.getCourseCode());
                startActivity(intent);
            }
        });

    }


}