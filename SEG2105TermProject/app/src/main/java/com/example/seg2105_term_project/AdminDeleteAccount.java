package com.example.seg2105_term_project;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDeleteAccount extends AppCompatActivity {
    TextView wholeView;
    EditText deleteAccountInput;
    Button confirmDeleteAccountButton;
    Cursor cursor;
    MyDBHandler myDBHandler;
    StringBuilder stringBuilder;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_delete_account);
        getSupportActionBar().setTitle("Account Management");

        myDBHandler = new MyDBHandler(this);

         wholeView = findViewById(R.id.wholeView);
         deleteAccountInput =  findViewById(R.id.deleteAccountInput);
         confirmDeleteAccountButton =  findViewById(R.id.confirmDeleteAccountButton);


        display();
        confirmDeleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!deleteAccountInput.getText().toString().equals("")){
                    if(myDBHandler.findProduct(deleteAccountInput.getText().toString()) != null && myDBHandler.findProduct(deleteAccountInput.getText().toString()).getUsername().equals(CurrentUser.getUsername())){
                        Toast toast = Toast.makeText(getApplicationContext(), "Cannot delete current account!", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                        deleteAccountInput.setText("");
                    }
                    else if(myDBHandler.deleteProduct(deleteAccountInput.getText().toString())){

                        display();
                        deleteAccountInput.setText("");
                        Toast toast = Toast.makeText(getApplicationContext(), "Account Successfully Deleted", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        deleteAccountInput.setText("");
                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid Account Name", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter account name", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }
            }
        });
    }

    public void display(){
        stringBuilder = new StringBuilder();
        cursor = myDBHandler.viewData();
        boolean flag = false;
        while (cursor.moveToNext()) {

            flag = true;
            int index = stringBuilder.indexOf("No Data To Show");
            if (index!=-1){
                stringBuilder.delete(0,"No Data To Show".length());
            }
            stringBuilder.append("\nUsername: " + cursor.getString(1) + "\nUser Role: " + cursor.getString(3));
            stringBuilder.append("\n");
        }

        if(!flag){
            stringBuilder.append("No Data To Show");
        }
        wholeView.setText(stringBuilder);
    }
}
