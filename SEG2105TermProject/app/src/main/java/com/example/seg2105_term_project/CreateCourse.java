package com.example.seg2105_term_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        createCourseButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForCreate.getText().toString();
                String code = inputCodeForCreate.getText().toString();
                if (!name.equals("") && !code.equals("")) {
                    if (handlerCourses.findCourse(name, code) == null) {
                        Course course = new Course(name, code);
                        handlerCourses.addCourse(course);
                        Toast toast = Toast.makeText(getApplicationContext(), "COURSE HAS BEEN CREATED", Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "COURSE WITH SAME CODE ALREADY EXISTS", Toast.LENGTH_LONG);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "PLEASE INPUT THE NAME AND CODE OF THE COURSE YOU WISH TO ADD", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }

}
