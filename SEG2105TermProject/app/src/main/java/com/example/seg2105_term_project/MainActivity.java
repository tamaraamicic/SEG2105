package com.example.seg2105_term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Button registerButton;
    EditText userNameEditText;
    EditText passwordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)(findViewById(R.id.signInButton));
        registerButton = (Button)(findViewById(R.id.registerButton));
        userNameEditText = (EditText) (findViewById(R.id.username));
        passwordEditText = (EditText) (findViewById(R.id.password));

        User user = new User("admin","admin123");

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!userNameEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    VerifyLogin verifyLogin = new VerifyLogin(userNameEditText.getText().toString(),passwordEditText.getText().toString());
                    if(verifyLogin.verified()){

                    }
                }
            }
        });



    }



}