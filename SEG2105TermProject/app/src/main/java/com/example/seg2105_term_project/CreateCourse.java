package com.example.seg2105_term_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class CreateCourse extends AppCompatActivity {

    TextInputEditText inputNameForCreate;
    TextInputEditText inputCodeForCreate;
    Button createCourseButton2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_course);

        inputNameForCreate = (TextInputEditText) (findViewById(R.id.inputNameForCreate));
        inputCodeForCreate = (TextInputEditText) (findViewById(R.id.inputCodeForCreate));
        createCourseButton2 = (Button)(findViewById(R.id.createCourseButton2));

        createCourseButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!inputNameForCreate.getText().toString().equals("") && !inputCodeForCreate.getText().toString().equals("")) {

                }
            }
        });

    }

}
