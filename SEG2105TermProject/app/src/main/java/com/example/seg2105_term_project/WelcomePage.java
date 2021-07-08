package com.example.seg2105_term_project;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomePage extends AppCompatActivity {
    TextView welcomeMessage;
    Button continueButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        getSupportActionBar().setTitle("Welcome Page");

        continueButton = (Button) findViewById(R.id.continueButton);
        welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        welcomeMessage.setText("Welcome "+CurrentUser.getUsername()+", your role is "+ CurrentUser.getRole());

        continueButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                if(CurrentUser.getRole().equals("admin")){
                    Intent intent = new Intent(getApplicationContext(),AdminPage.class);
                    startActivity(intent);
                }else if(CurrentUser.getRole().equals("instructor")){
                    Intent intent = new Intent(getApplicationContext(),InstructorPage.class);
                    startActivity(intent);
                }else if(CurrentUser.getRole().equals("student")){
                    Intent intent = new Intent(getApplicationContext(), StudentPage.class);
                    startActivity(intent);
                }
            }
        });
    }
}
