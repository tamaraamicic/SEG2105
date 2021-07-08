package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorPage extends AppCompatActivity {

    Button viewForInstructorPage;
    Button assignForInstructorPage;
    Button unassignForInstructorPage;
    Button editForInstructorPage;
    Button viewStudentsInstructorPage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_page);

        viewForInstructorPage = (Button)findViewById(R.id.viewForInstructorPage);
        assignForInstructorPage = (Button)findViewById(R.id.assignForInstructorPage);
        unassignForInstructorPage = (Button)findViewById(R.id.unassignForInstructorPage);
        editForInstructorPage = (Button)findViewById(R.id.editForInstructorPage);
        viewStudentsInstructorPage = (Button)findViewById(R.id.viewStudentsInstructorPage);

        viewForInstructorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructorViewCourses.class);
                startActivity(intent);
            }
        });

        assignForInstructorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructorAssignCourse.class);
                startActivity(intent);
            }
        });

        unassignForInstructorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructorUnassignCourse.class);
                startActivity(intent);
            }
        });

        editForInstructorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructorEditCourse.class);
                startActivity(intent);
            }
        });

        viewStudentsInstructorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructorViewStudents.class);
                startActivity(intent);
            }
        });

    }
}
