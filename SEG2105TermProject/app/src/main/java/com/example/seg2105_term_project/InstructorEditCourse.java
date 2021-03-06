package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InstructorEditCourse extends AppCompatActivity {

    TextInputEditText inputNameForInstructorEditCourse;
    TextInputEditText inputCodeForInstructorEditCourse;
    Button searchButtonForInstructorEditCourse;
    Button editButtonForInstructorEditCourse;
    Course course;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_edit_course);
        getSupportActionBar().setTitle("Course Modification");

        inputNameForInstructorEditCourse = (TextInputEditText) (findViewById(R.id.inputNameForInstructorEditCourse));
        inputCodeForInstructorEditCourse = (TextInputEditText) (findViewById(R.id.inputCodeForInstructorEditCourse));
        searchButtonForInstructorEditCourse = (Button) (findViewById(R.id.searchButtonForInstructorEditCourse));
        editButtonForInstructorEditCourse = (Button) (findViewById(R.id.editButtonForInstructorEditCourse));
        editButtonForInstructorEditCourse.setEnabled(false);


        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        searchButtonForInstructorEditCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String name = inputNameForInstructorEditCourse.getText().toString();
                String code = inputCodeForInstructorEditCourse.getText().toString();
                if (name == null && code == null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No Field Has Text. Please retry", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    course = handlerCourses.findCourse(name, code);
                    if (course != null) {
                        if (code.equals("")) {
                            inputCodeForInstructorEditCourse.setText(course.getCourseCode());
                        } else if (name.equals("")) {
                            inputNameForInstructorEditCourse.setText(course.getCourseName());
                        }
                        if (!course.getInstructor().equals(CurrentUser.getUsername())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "You do not teach this course. Please retry", Toast.LENGTH_LONG);
                            toast.show();
                        } else {
                            editButtonForInstructorEditCourse.setEnabled(true);
                        }

                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });

        editButtonForInstructorEditCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructorEditCoursePart2.class);
                intent.putExtra("mainCourse",course.getCourseCode());
                startActivity(intent);
            }
        });

    }
}
