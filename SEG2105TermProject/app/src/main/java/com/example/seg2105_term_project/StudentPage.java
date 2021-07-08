package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StudentPage extends AppCompatActivity {

    Button studentViewCourses;
    Button viewEnrolledCoursesButton;
    Button enrollButton;
    Button unenrollButton ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_page);

        studentViewCourses = findViewById(R.id.studentViewCourses);
        viewEnrolledCoursesButton = findViewById(R.id.studentViewEnrolledCourses);
        enrollButton = findViewById(R.id.studentEnrollCourse);
        unenrollButton = findViewById(R.id.studentUnenrollCourse);

        viewEnrolledCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminCreateCourse.class);
                startActivity(intent);
            }
        });

        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), .class);
                startActivity(intent);
            }
        });

        unenrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminCreateCourse.class);
                startActivity(intent);
            }
        });
    }
}
