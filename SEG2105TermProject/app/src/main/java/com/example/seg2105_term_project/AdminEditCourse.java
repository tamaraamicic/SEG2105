package com.example.seg2105_term_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AdminEditCourse extends AppCompatActivity {

    TextInputEditText inputNameForEdit;
    TextInputEditText inputCodeForEdit;
    Button findCourseButtonForEdit;
    Button saveChangesButtonForEdit;
    TextInputEditText inputNewNameForEdit;
    TextInputEditText inputNewCodeForEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_edit_course);
        getSupportActionBar().setTitle("Course Modification");

        inputNameForEdit = (TextInputEditText) (findViewById(R.id.inputNameForEdit));
        inputCodeForEdit = (TextInputEditText) (findViewById(R.id.inputCodeForEdit));
        findCourseButtonForEdit = (Button)(findViewById(R.id.findCourseButtonForEdit));
        saveChangesButtonForEdit = (Button)(findViewById(R.id.saveChangesButtonForEdit));
        saveChangesButtonForEdit.setEnabled(false);
        inputNewNameForEdit = (TextInputEditText) (findViewById(R.id.inputNewNameForEdit));
        inputNewCodeForEdit = (TextInputEditText) (findViewById(R.id.inputNewCodeForEdit));
        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        findCourseButtonForEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForEdit.getText().toString();
                String code = inputCodeForEdit.getText().toString();
                Course course = handlerCourses.findCourse(name, code);
                if (course != null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course found!", Toast.LENGTH_LONG);
                    toast.show();
                    saveChangesButtonForEdit.setEnabled(true);
                    if (code.equals("")) {
                        inputCodeForEdit.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForEdit.setText(course.getCourseName());
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        saveChangesButtonForEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForEdit.getText().toString();
                String code = inputCodeForEdit.getText().toString();

                Course courseToAdd;
                String newName = inputNewNameForEdit.getText().toString();
                String newCode = inputNewCodeForEdit.getText().toString();
                if(!newName.equals("") && !newCode.equals("")){
                    if(handlerCourses.findCourse(newName,newCode) == null){
                        handlerCourses.deleteCourse(name, code);
                        courseToAdd = new Course(newName, newCode);
                        handlerCourses.addCourse(courseToAdd);
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(), "This course already exists", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please make sure all fields have input", Toast.LENGTH_LONG);
                    toast.show();
                }



                saveChangesButtonForEdit.setEnabled(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Course has been edited", Toast.LENGTH_LONG);
                toast.show();

            }
        });

    }

}
