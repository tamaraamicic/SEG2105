package com.example.seg2105_term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Button registerAdminButton;
    Button registerInstructorButton;
    Button registerStudentButton;
    EditText userNameEditText;
    EditText passwordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)(findViewById(R.id.signInButton));
        registerAdminButton = (Button)(findViewById(R.id.registerAdminButton));
        registerInstructorButton = (Button)(findViewById(R.id.registerInstructorButton));
        registerStudentButton = (Button)(findViewById(R.id.registerStudentButton));
        userNameEditText = (EditText) (findViewById(R.id.username));
        passwordEditText = (EditText) (findViewById(R.id.password));
        MyDBHandler myDBHandler = new MyDBHandler(this);
        User user = new User("administrator","admin123");
        user.setRole("admin");
        if(myDBHandler.findProduct(user.getUsername())==null){
            myDBHandler.addProduct(user);
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!userNameEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    VerifyLogin verifyLogin = new VerifyLogin(userNameEditText.getText().toString(),passwordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        if(verifyLogin.roleNumber(myDBHandler) == 0){
                            CurrentUser.setUsername(userNameEditText.getText().toString());
                            CurrentUser.setPassword(passwordEditText.getText().toString());
                            CurrentUser.setRole(verifyLogin.getRoleName(myDBHandler));
                            Intent intent = new Intent(getApplicationContext(),AdminPage.class);
                            startActivity(intent);
                        }else if(verifyLogin.roleNumber(myDBHandler) == 1){
                            CurrentUser.setUsername(userNameEditText.getText().toString());
                            CurrentUser.setPassword(passwordEditText.getText().toString());
                            CurrentUser.setRole(verifyLogin.getRoleName(myDBHandler));
                            Intent intent = new Intent(getApplicationContext(),InstructorPage.class);
                            startActivity(intent);
                        }else if(verifyLogin.roleNumber(myDBHandler) == 2) {
                            CurrentUser.setUsername(userNameEditText.getText().toString());
                            CurrentUser.setPassword(passwordEditText.getText().toString());
                            CurrentUser.setRole(verifyLogin.getRoleName(myDBHandler));
                            Intent intent = new Intent(getApplicationContext(), StudentPage.class);
                            startActivity(intent);
                        }else if(verifyLogin.roleNumber(myDBHandler) == -1){
                            Toast toast = Toast.makeText(getApplicationContext(), "AN ERROR OCCURRED", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                            toast.show();
                        }
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid Info\nPlease use Register Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }
                }
            }
        });
        registerAdminButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!userNameEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    VerifyLogin verifyLogin = new VerifyLogin(userNameEditText.getText().toString(),passwordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Username already exists\nPlease use login Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        User user = new User(userNameEditText.getText().toString(),passwordEditText.getText().toString());
                        user.setRole("admin");
                        myDBHandler.addProduct(user);
                    }
                }
            }
        });
        registerInstructorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!userNameEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    VerifyLogin verifyLogin = new VerifyLogin(userNameEditText.getText().toString(),passwordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Username already exists\nPlease use login Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        User user = new User(userNameEditText.getText().toString(),passwordEditText.getText().toString());
                        user.setRole("instructor");
                        myDBHandler.addProduct(user);
                    }
                }
            }
        });
        registerStudentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!userNameEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    VerifyLogin verifyLogin = new VerifyLogin(userNameEditText.getText().toString(),passwordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Username already exists\nPlease use login Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        User user = new User(userNameEditText.getText().toString(),passwordEditText.getText().toString());
                        user.setRole("student");
                        myDBHandler.addProduct(user);
                    }
                }
            }
        });


    }
}