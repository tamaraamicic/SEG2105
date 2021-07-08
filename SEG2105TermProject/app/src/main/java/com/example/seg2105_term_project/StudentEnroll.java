package com.example.seg2105_term_project;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class StudentEnroll extends AppCompatActivity {

    TextInputEditText inputNameForEnroll;
    TextInputEditText inputCodeForEnroll;
    TextInputEditText inputDateForEnroll;
    Button searchButtonForEnroll;
    Button enrollButtonForEnroll;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_enroll);

        inputNameForEnroll = (TextInputEditText) (findViewById(R.id.inputNameForEnroll));
        inputCodeForEnroll = (TextInputEditText) (findViewById(R.id.inputCodeForEnroll));
        inputDateForEnroll = (TextInputEditText) (findViewById(R.id.inputDateForEnroll));
        searchButtonForEnroll = (Button) (findViewById(R.id.searchButtonForEnroll));
        enrollButtonForEnroll = (Button) (findViewById(R.id.enrollButtonForEnroll));

    }
}
