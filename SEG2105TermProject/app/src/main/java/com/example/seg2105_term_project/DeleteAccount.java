package com.example.seg2105_term_project;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteAccount extends AppCompatActivity {
    TextView wholeView;
    EditText deleteAccountInput;
    Button confirmDeleteAccountButton;
    Cursor cursor;
    MyDBHandler myDBHandler;
    StringBuilder stringBuilder;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_accounts);

        myDBHandler = new MyDBHandler(this);

         wholeView = findViewById(R.id.wholeView);
         deleteAccountInput =  findViewById(R.id.deleteAccountInput);
         confirmDeleteAccountButton =  findViewById(R.id.confirmDeleteAccountButton);
         cursor = myDBHandler.viewData();

        stringBuilder = new StringBuilder("No Data To Show");
        display(stringBuilder);
        confirmDeleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!deleteAccountInput.getText().toString().equals("")){
                    if(myDBHandler.deleteProduct(deleteAccountInput.getText().toString())){

                        display(stringBuilder);

                        Toast toast = Toast.makeText(getApplicationContext(), "Account Successfully Deleted", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(), "Invalid Account Name", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                        toast.show();
                    }
                }
            }
        });
    }

    public void display(StringBuilder stringBuilder){

        cursor.moveToFirst();
        if(!cursor.moveToNext()){
            stringBuilder = new StringBuilder("No Data To Show");
        }
        while (cursor.moveToNext()) {


            int index = stringBuilder.indexOf("No Data To Show");
            if (index!=-1){
                stringBuilder.delete(0,"No Data To Show".length());
            }
            stringBuilder.append("\nUsername: " + cursor.getString(1) + "\nUser Role: " + cursor.getString(3));
            stringBuilder.append("\n");
        }


        wholeView.setText(stringBuilder);
    }

    @Override
    protected void onResume() {
        super.onResume();
        display(stringBuilder);
    }
}
