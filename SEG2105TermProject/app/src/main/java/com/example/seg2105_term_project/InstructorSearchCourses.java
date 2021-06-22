package com.example.seg2105_term_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class InstructorSearchCourses extends AppCompatActivity {

    TextInputEditText inputNameForSearch;
    TextInputEditText inputCodeForSearch;
    Button searchButton;
    Button assignButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_search_courses);

        inputNameForSearch = (TextInputEditText) (findViewById(R.id.inputNameForSearch));
        inputCodeForSearch = (TextInputEditText) (findViewById(R.id.inputCodeForSearch));
        searchButton = (Button)(findViewById(R.id.searchButton));
        assignButton = (Button)(findViewById(R.id.assignButton));

        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForSearch.getText().toString();
                String code = inputCodeForSearch.getText().toString();
                Course course = handlerCourses.findCourse(name, code);
                if (course != null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course found!", Toast.LENGTH_LONG);
                    toast.show();
                    //deleteButtonForDelete.setEnabled(true);
                    if (code.equals("")) {
                        inputCodeForSearch.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForSearch.setText(course.getCourseName());
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }


}