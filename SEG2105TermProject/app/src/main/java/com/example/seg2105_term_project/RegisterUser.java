package com.example.seg2105_term_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterUser extends AppCompatActivity {
    Button registerAdminButton;
    Button registerInstructorButton;
    Button registerStudentButton;
    EditText registerNameEditText;
    EditText registerPasswordEditText;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Registration Page");
        setContentView(R.layout.register_page);
        MyDBHandler myDBHandler = new MyDBHandler(this);


        registerAdminButton = (Button)(findViewById(R.id.registerAdminButton));
        registerInstructorButton = (Button)(findViewById(R.id.registerInstructorButton));
        registerStudentButton = (Button)(findViewById(R.id.registerStudentButton));
        registerNameEditText = (EditText) (findViewById(R.id.registerNameEditText));
        registerPasswordEditText = (EditText) (findViewById(R.id.registerPasswordEditText));



        registerAdminButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!registerNameEditText.getText().toString().equals("") && !registerPasswordEditText.getText().toString().equals("")){
                    VerifyLogin verifyLogin = new VerifyLogin(registerNameEditText.getText().toString(),registerPasswordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Username already exists\nPlease use login Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        User user = new User(registerNameEditText.getText().toString(),registerPasswordEditText.getText().toString());
                        user.setRole("admin");
                        myDBHandler.addProduct(user);
                        Toast toast = Toast.makeText(getApplicationContext(), "User "+user.getUsername()+" has been registered as "+user.getRole(), Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please make sure all fields have input", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
            }
        });
        registerInstructorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!registerNameEditText.getText().toString().equals("") && !registerPasswordEditText.getText().toString().equals("") ){
                    VerifyLogin verifyLogin = new VerifyLogin(registerNameEditText.getText().toString(),registerPasswordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Username already exists\nPlease use login Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        User user = new User(registerNameEditText.getText().toString(),registerPasswordEditText.getText().toString());
                        user.setRole("instructor");
                        myDBHandler.addProduct(user);
                        Toast toast = Toast.makeText(getApplicationContext(), "User "+user.getUsername()+" has been registered as "+user.getRole(), Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please make sure all fields have input", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
            }

        });
        registerStudentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!registerNameEditText.getText().toString().equals("") && !registerPasswordEditText.getText().toString().equals("") ){
                    VerifyLogin verifyLogin = new VerifyLogin(registerNameEditText.getText().toString(),registerPasswordEditText.getText().toString());

                    if(verifyLogin.verified(myDBHandler)){
                        Toast toast = Toast.makeText(getApplicationContext(), "Username already exists\nPlease use login Button", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        User user = new User(registerNameEditText.getText().toString(),registerPasswordEditText.getText().toString());
                        user.setRole("student");
                        myDBHandler.addProduct(user);
                        Toast toast = Toast.makeText(getApplicationContext(), "User "+user.getUsername()+" has been registered as "+user.getRole(), Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please make sure all fields have input", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
            }
        });
    }
}
