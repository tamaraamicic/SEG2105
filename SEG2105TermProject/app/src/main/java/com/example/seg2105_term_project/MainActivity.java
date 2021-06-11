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
        MyDBHandler myDBHandler = new MyDBHandler(this);
        User user = new User("administrator","admin123");
        user.setRole("admin");
        if(myDBHandler.findProduct(user.getUsername())==null){
            myDBHandler.addProduct(user);
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(userNameEditText.getText().toString().equals("") || passwordEditText.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please make sure all fields contain information", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
                if(!userNameEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    VerifyLogin verifyLogin = new VerifyLogin(userNameEditText.getText().toString(),passwordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        if(verifyLogin.roleNumber(myDBHandler) == 0){
                            CurrentUser.setUsername(userNameEditText.getText().toString());
                            CurrentUser.setPassword(passwordEditText.getText().toString());
                            CurrentUser.setRole(verifyLogin.getRoleName(myDBHandler));
                        }else if(verifyLogin.roleNumber(myDBHandler) == 1){
                            CurrentUser.setUsername(userNameEditText.getText().toString());
                            CurrentUser.setPassword(passwordEditText.getText().toString());
                            CurrentUser.setRole(verifyLogin.getRoleName(myDBHandler));
                        }else if(verifyLogin.roleNumber(myDBHandler) == 2) {
                            CurrentUser.setUsername(userNameEditText.getText().toString());
                            CurrentUser.setPassword(passwordEditText.getText().toString());
                            CurrentUser.setRole(verifyLogin.getRoleName(myDBHandler));
                        }
                        Intent intent = new Intent(getApplicationContext(), WelcomePage.class);
                        startActivity(intent);
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid Info\nPlease use Register Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterUser.class);
                startActivity(intent);
            }
        });



    }
}