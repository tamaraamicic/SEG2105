package com.example.seg2105_term_project;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class EditCourse extends AppCompatActivity {

    TextInputEditText inputNameForEdit;
    TextInputEditText inputCodeForEdit;
    Button findCourseButtonForEdit;
    Button saveChangesButtonForEdit;
    TextInputEditText inputNewNameForEdit;
    TextInputEditText inputNewCodeForEdit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_course);

        inputNameForEdit = (TextInputEditText) (findViewById(R.id.inputNameForEdit));
        inputCodeForEdit = (TextInputEditText) (findViewById(R.id.inputCodeForEdit));
        findCourseButtonForEdit = (Button)(findViewById(R.id.findCourseButtonForEdit));
        saveChangesButtonForEdit = (Button)(findViewById(R.id.saveChangesButtonForEdit));
        inputNewNameForEdit = (TextInputEditText) (findViewById(R.id.inputNewNameForEdit));
        inputNewCodeForEdit = (TextInputEditText) (findViewById(R.id.inputNewCodeForEdit));
    }

}
