package com.example.seg2105_term_project;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InstructorEditCourse extends AppCompatActivity {

    TextInputEditText inputNameForInstructorEditCourse;
    TextInputEditText inputCodeForInstructorEditCourse;
    Button searchButtonForInstructorEditCourse;
    Button editButtonForInstructorEditCourse;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_assign_course);

        inputNameForInstructorEditCourse = (TextInputEditText) (findViewById(R.id.inputNameForInstructorEditCourse));
        inputCodeForInstructorEditCourse = (TextInputEditText) (findViewById(R.id.inputCodeForInstructorEditCourse));
        searchButtonForInstructorEditCourse = (Button) (findViewById(R.id.searchButtonForInstructorEditCourse));
        editButtonForInstructorEditCourse = (Button) (findViewById(R.id.editButtonForInstructorEditCourse));
        editButtonForInstructorEditCourse.setEnabled(false);
    }
}
