package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InstructorPage extends AppCompatActivity {

    Button viewCoursesButton;
    Button searchCoursesButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intructor_page);

        viewCoursesButton = (Button)findViewById(R.id.viewCoursesButton);
        searchCoursesButton = (Button)findViewById(R.id.searchCoursesButton);

        viewCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewCoursesPage.class);
                startActivity(intent);
            }
        });

        searchCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InstructorSearchCourses.class);
                startActivity(intent);
            }
        });

    }
}
