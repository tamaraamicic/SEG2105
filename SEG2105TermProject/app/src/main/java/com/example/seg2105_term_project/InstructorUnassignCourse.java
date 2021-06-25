package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InstructorUnassignCourse extends AppCompatActivity {

    TextInputEditText inputNameForUnassign;
    TextInputEditText inputCodeForUnassign;
    Button searchButtonForUnassign;
    Button unassignButtonForUnassign;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_unassign_course);

        inputNameForUnassign = (TextInputEditText) (findViewById(R.id.inputNameForUnassign));
        inputCodeForUnassign = (TextInputEditText) (findViewById(R.id.inputCodeForUnassign));
        searchButtonForUnassign = (Button)(findViewById(R.id.searchButtonForUnassign));
        unassignButtonForUnassign = (Button)(findViewById(R.id.unassignButtonForUnassign));
        unassignButtonForUnassign.setEnabled(false);

        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        searchButtonForUnassign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForUnassign.getText().toString();
                String code = inputCodeForUnassign.getText().toString();
                Course course = handlerCourses.findCourse(name, code);
                if (course != null) {
                    if (code.equals("")) {
                        inputCodeForUnassign.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForUnassign.setText(course.getCourseName());
                    }
                    if (course.getInstructor().equals("")) {
                        Toast toast = Toast.makeText(getApplicationContext(), "You do not teach this course. Please retry", Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        if (course.getInstructor().equals(CurrentUser.getUsername())) {
                            unassignButtonForUnassign.setEnabled(true);
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "You do not teach this course. Please retry", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}
