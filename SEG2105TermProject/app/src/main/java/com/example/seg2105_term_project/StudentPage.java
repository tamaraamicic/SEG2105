package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StudentPage extends AppCompatActivity {

    Button studentViewCourses;
    Button viewEnrolledCoursesButton;
    Button enrollButton;
    Button unenrollButton ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_page);

        studentViewCourses = findViewById(R.id.studentViewCourses);
        viewEnrolledCoursesButton = findViewById(R.id.studentViewEnrolledCourses);
        enrollButton = findViewById(R.id.studentEnrollCourse);
        unenrollButton = findViewById(R.id.studentUnenrollCourse);

        studentViewCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentViewCourses.class);
                startActivity(intent);
            }
        });

        viewEnrolledCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentViewEnrolledCourses.class);
                startActivity(intent);
            }
        });

        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentEnroll.class);
                startActivity(intent);
            }
        });

        unenrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentUnenroll.class);
                startActivity(intent);
            }
        });
    }
}
