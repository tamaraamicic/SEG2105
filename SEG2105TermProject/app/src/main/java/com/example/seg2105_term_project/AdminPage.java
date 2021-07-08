package com.example.seg2105_term_project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPage extends AppCompatActivity {

    Button createCourseButton;
    Button editCourseButton;
    Button deleteCourseButton;
    Button deleteAccountButton;
    TextView roleDisplay;
    TextView nameDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);
        getSupportActionBar().setTitle("Admin Activity");

        createCourseButton = (Button)findViewById(R.id.createCourseButton);
        editCourseButton = (Button)findViewById(R.id.editCourseButton);
        deleteCourseButton = (Button)findViewById(R.id.deleteCourseButton);
        deleteAccountButton = (Button)findViewById(R.id.deleteAccountButton);
        roleDisplay = (TextView) findViewById(R.id.roleDisplay);
        nameDisplay = (TextView)findViewById(R.id.nameDisplay);

        nameDisplay.setText(CurrentUser.getUsername());
        roleDisplay.setText(CurrentUser.getRole());

        createCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminCreateCourse.class);
                startActivity(intent);
            }
        });

        editCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminEditCourse.class);
                startActivity(intent);
            }
        });

        deleteCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminDeleteCourse.class);
                startActivity(intent);
            }
        });

        deleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminDeleteAccount.class);
                startActivity(intent);
            }
        });

    }
}
