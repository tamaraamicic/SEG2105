package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InstructorAssignCourse extends AppCompatActivity {

    TextInputEditText inputNameForAssign;
    TextInputEditText inputCodeForAssign;
    Button searchButtonForAssign;
    Button assignButtonForAssign;
    Course course;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_assign_course);

        inputNameForAssign = (TextInputEditText) (findViewById(R.id.inputNameForAssign));
        inputCodeForAssign = (TextInputEditText) (findViewById(R.id.inputCodeForAssign));
        searchButtonForAssign = (Button)(findViewById(R.id.searchButtonForAssign));
        assignButtonForAssign = (Button)(findViewById(R.id.assignButtonForAssign));
        assignButtonForAssign.setEnabled(false);

        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        searchButtonForAssign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForAssign.getText().toString();
                String code = inputCodeForAssign.getText().toString();
                course = handlerCourses.findCourse(name, code);
                if (course != null) {
                    if (code.equals("")) {
                        inputCodeForAssign.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForAssign.setText(course.getCourseName());
                    }
                    if (!course.getInstructor().equals("")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(InstructorAssignCourse.this);
                        builder.setMessage("This course is already taught by " + course.getInstructor()
                                + ", therefore you may not assign yourself to it.").setTitle("Notice");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(InstructorAssignCourse.this);
                        builder.setMessage("This course is open! You may assign yourself to it").setTitle("Notice");
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        assignButtonForAssign.setEnabled(true);
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        assignButtonForAssign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InstructorAssignCoursePart2.class);
                intent.putExtra("mainCourse",course.getCourseName());
                startActivity(intent);
            }
        });

    }


}