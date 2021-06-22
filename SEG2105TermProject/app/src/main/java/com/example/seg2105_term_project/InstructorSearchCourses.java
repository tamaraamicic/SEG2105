package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InstructorSearchCourses extends AppCompatActivity {

    TextInputEditText inputNameForSearch;
    TextInputEditText inputCodeForSearch;
    Button searchButtonForSearch;
    Button assignButtonForSearch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_search_courses);

        inputNameForSearch = (TextInputEditText) (findViewById(R.id.inputNameForSearch));
        inputCodeForSearch = (TextInputEditText) (findViewById(R.id.inputCodeForSearch));
        searchButtonForSearch = (Button)(findViewById(R.id.searchButtonForSearch));
        assignButtonForSearch = (Button)(findViewById(R.id.assignButtonForSearch));
        assignButtonForSearch.setEnabled(false);

        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        searchButtonForSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForSearch.getText().toString();
                String code = inputCodeForSearch.getText().toString();
                Course course = handlerCourses.findCourse(name, code);
                if (course != null) {
                    if (code.equals("")) {
                        inputCodeForSearch.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForSearch.setText(course.getCourseName());
                    }
                    if (course.getInstructor() != null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(InstructorSearchCourses.this);
                        builder.setMessage("This course is already taught by " + course.getInstructor()
                                + ", therefore you may not assign yourself to it.").setTitle("Notice");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(InstructorSearchCourses.this);
                        builder.setMessage("This course is open! You may assign yourself to it").setTitle("Notice");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        assignButtonForSearch.setEnabled(true);
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        assignButtonForSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AssignCourse.class);
                startActivity(intent);
            }
        });

    }


}